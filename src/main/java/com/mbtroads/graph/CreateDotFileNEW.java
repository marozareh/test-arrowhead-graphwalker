package com.mbtroads.graph;

import com.mbtroads.core.ISystemProperties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class CreateDotFileNEW implements ISystemProperties {

    private static final JSONParser jsonParser = new JSONParser();

    private static final List<String> sourceVertexNames = new ArrayList<>();
    private static final List<String> targetVertexNames = new ArrayList<>();
    private static final List<String> edgeNames = new ArrayList<>();
    private static final List<String> vertexNames = new ArrayList<>();

    private static int vertexCount = 0;
    private static int edgeCount = 0;

    /* =========================================================
       MAIN ENTRY
       ========================================================= */

    public static void ReadFile(String filename,
                                Set<String> failedVertices,
                                Set<String> failedEdges,
                                String reportFolder)
            throws IOException {

        resetState();

        try {

            InputStream is = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("graphwalker/" + filename + ".json");

            if (is == null) {
                throw new FileNotFoundException("Model not found: " + filename);
            }

            JSONObject root =
                    (JSONObject) jsonParser.parse(new InputStreamReader(is));

            JSONArray models = (JSONArray) root.get("models");
            JSONObject model = (JSONObject) models.get(0);

            Map<String, String> idToNameMap = new HashMap<>();

            // ---- Read vertices
            JSONArray vertices = (JSONArray) model.get("vertices");
            for (Object vertexObj : vertices) {

                JSONObject vertex = (JSONObject) vertexObj;

                String id = (String) vertex.get("id");
                String name = (String) vertex.get("name");

                if (id != null && name != null) {
                    idToNameMap.put(id, name);
                    vertexNames.add(name);
                }
            }

            // ---- Read edges
            JSONArray edges = (JSONArray) model.get("edges");
            for (Object edgeObj : edges) {

                JSONObject edge = (JSONObject) edgeObj;

                String sourceId = (String) edge.get("sourceVertexId");
                String targetId = (String) edge.get("targetVertexId");
                String edgeName = (String) edge.get("name");

                String sourceName = idToNameMap.get(sourceId);
                String targetName = idToNameMap.get(targetId);

                if (sourceName != null && targetName != null && edgeName != null) {

                    sourceVertexNames.add(sourceName);
                    targetVertexNames.add(targetName);
                    edgeNames.add(edgeName);
                }
            }

            vertexCount = vertexNames.size();
            edgeCount = edgeNames.size();

            writeDot(filename, failedVertices, failedEdges, reportFolder);
            createPng(filename, reportFolder);

        } catch (ParseException e) {
            throw new RuntimeException("JSON parsing failed", e);
        }
    }

    /* ========================================================= */

    private static void resetState() {
        sourceVertexNames.clear();
        targetVertexNames.clear();
        edgeNames.clear();
        vertexNames.clear();
        vertexCount = 0;
        edgeCount = 0;
    }

    /* ========================================================= */

    public static int getVertexCount() {
        return vertexCount;
    }

    public static int getEdgeCount() {
        return edgeCount;
    }

    public static Set<String> getVertexNameSet() {
        return new HashSet<>(vertexNames);
    }

    public static Set<String> getEdgeNameSet() {
        return new HashSet<>(edgeNames);
    }

    /* ========================================================= */

    private static void writeDot(String filename,
                                 Set<String> failedVertices,
                                 Set<String> failedEdges,
                                 String reportFolder)
            throws IOException {

        File outDir = new File(currentDir + pathSeperator + reportFolder);
        outDir.mkdirs();

        File dotFile = new File(outDir, filename + ".dot");

        try (FileWriter writer = new FileWriter(dotFile)) {

            writer.write("digraph " + filename + " {\n");
            writer.write("rankdir=LR;\n");

            // IMPORTANT: no global color
            writer.write("node [shape=box style=filled];\n");

            // ---- Draw vertices (Blue by default, Red if failed)
            for (String vertex : vertexNames) {

                String color = failedVertices.contains(vertex)
                        ? "lightcoral"
                        : "lightblue";

                writer.write("\"" + vertex + "\" [fillcolor=" + color + "];\n");
            }

            // ---- Draw edges (Black by default, Red if failed)
            for (int i = 0; i < edgeNames.size(); i++) {

                String edgeName = edgeNames.get(i);

                String color = failedEdges.contains(edgeName)
                        ? "red"
                        : "black";

                writer.write(
                        "\"" + sourceVertexNames.get(i) + "\" -> \"" +
                                targetVertexNames.get(i) +
                                "\" [label=\"" + edgeName +
                                "\" color=\"" + color + "\"];\n"
                );
            }

            writer.write("}\n");
        }
    }

    /* ========================================================= */

    private static void createPng(String filename,
                                  String reportFolder) {

        try {

            String reportsDir =
                    currentDir + pathSeperator + reportFolder;

            String dotFile =
                    reportsDir + pathSeperator + filename + ".dot";

            String pngFile =
                    reportsDir + pathSeperator + filename + ".png";

            ProcessBuilder builder = new ProcessBuilder(
                    "dot",
                    "-Tpng",
                    dotFile,
                    "-o",
                    pngFile
            );

            builder.redirectErrorStream(true);

            Process process = builder.start();
            process.waitFor();

            System.out.println("PNG created: " + pngFile);

        } catch (Exception e) {
            throw new RuntimeException("Graphviz PNG generation failed", e);
        }
    }
}
