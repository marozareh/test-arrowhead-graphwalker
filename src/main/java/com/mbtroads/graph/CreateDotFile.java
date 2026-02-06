package com.mbtroads.graph;

import com.mbtroads.core.ISystemProperties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;

public class CreateDotFile implements ISystemProperties {

    public static JSONParser jsonParser = new JSONParser();
    public static Object object;

    public static String[] targetVertex = new String[30];
    public static String[] sourceVertex = new String[30];
    public static String[] targetVertexName = new String[30];
    public static String[] sourceVertexName = new String[30];
    public static String[] failedVertexName = new String[30];
    public static String[] failedEdgeName = new String[30];

    public static String[] name = new String[30];
    public static String[] EdgeColor = new String[30];

    public static String[] VertexID = new String[30];
    public static String[] VertexName = new String[30];

    public static int countEdges = 0;
    public static int countVertx = 0;
    public static int countVertxFailed = 0;
    public static int countEdgeFailed = 0;

    /* =========================================================
       MAIN ENTRY
       ========================================================= */

    public static void ReadFile(String filename, int failtest, String strMain) throws IOException {

        resetState();

        try {
            InputStream is = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("graphwalker/" + filename + ".json");

            if (is == null) {
                throw new FileNotFoundException(
                        "graphwalker/" + filename + ".json not found on classpath"
                );
            }

            object = jsonParser.parse(new InputStreamReader(is));

            JSONObject jsonObject = (JSONObject) object;
            JSONArray models = (JSONArray) jsonObject.get("models");

            /* --------- Read edges & vertices --------- */
            for (Object modelObj : models.toArray()) {

                JSONObject model = (JSONObject) modelObj;

                JSONArray edgesList = (JSONArray) model.get("edges");
                for (Object edgeObj : edgesList.toArray()) {
                    JSONObject edge = (JSONObject) edgeObj;

                    targetVertex[countEdges] = (String) edge.get("targetVertexId");
                    sourceVertex[countEdges] = (String) edge.get("sourceVertexId");
                    name[countEdges] = (String) edge.get("name");

                    countEdges++;
                }

                JSONArray vertexList = (JSONArray) model.get("vertices");
                for (Object vertexObj : vertexList.toArray()) {
                    JSONObject vertex = (JSONObject) vertexObj;

                    VertexID[countVertx] = (String) vertex.get("id");
                    VertexName[countVertx] = (String) vertex.get("name");

                    countVertx++;
                }
            }

            /* --------- Replace vertex IDs with names --------- */
            mapVertexIdsToNames();

            /* --------- Failed nodes/edges --------- */
            if (failtest == 1) {
                CreateFailNodes(strMain);
            }

            writeDot(filename);
            Createpng(filename);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /* =========================================================
       INTERNAL HELPERS
       ========================================================= */

    private static void resetState() {
        countEdges = 0;
        countVertx = 0;
        countVertxFailed = 0;
        countEdgeFailed = 0;
    }

    private static void mapVertexIdsToNames() {
        for (int i = 0; i < countEdges; i++) {

            for (int j = 0; j < countVertx; j++) {
                if (targetVertex[i].equals(VertexID[j])) {
                    targetVertexName[i] = VertexName[j];
                    break;
                }
            }

            for (int j = 0; j < countVertx; j++) {
                if (sourceVertex[i].equals(VertexID[j])) {
                    sourceVertexName[i] = VertexName[j];
                    break;
                }
            }
        }
    }

    /* =========================================================
       DOT GENERATION
       ========================================================= */

    static void writeDot(String filename) throws IOException {

        File outDir = new File(currentDir + pathSeperator + "Drivers");
        outDir.mkdirs();

        FileWriter writer = new FileWriter(
                new File(outDir, filename + ".dot")
        );

        writer.write("digraph " + filename + "{\n");
        writer.write("rankdir=TB\n");
        writer.write("label=\"" + filename + "\"\n");
        writer.write("labelloc=top\n");
        writer.write("labeljust=left\n");
        writer.write("fontcolor=blue\n");
        writer.write("node [style=filled]\n");
        writer.write("fontsize=30\n");

        /* --------- Failed vertices --------- */
        for (int i = 0; i < countVertxFailed; i++) {
            writer.write("\"" + failedVertexName[i] + "\" [fillcolor=red]\n");
        }

        /* --------- Default edge colors --------- */
        for (int i = 0; i < countEdges; i++) {
            EdgeColor[i] = "black";
        }

        /* --------- Failed edges --------- */
        for (int i = 0; i < countEdgeFailed; i++) {
            for (int j = 0; j < countEdges; j++) {
                if (name[j].trim().equals(failedEdgeName[i].trim())) {
                    EdgeColor[j] = "red";
                }
            }
        }

        /* --------- Write edges --------- */
        for (int i = countEdges - 1; i >= 0; i--) {
            writer.write(
                    "\"" + sourceVertexName[i] + "\" -> \"" + targetVertexName[i] +
                            "\" [ label=\"" + name[i] + "\" color=\"" + EdgeColor[i] + "\" ]\n"
            );
        }

        writer.write("}");
        writer.close();
    }

    /* =========================================================
       PNG GENERATION
       ========================================================= */

    public static void Createpng(String filename) {

        try {
            Process p;

            if (OS.contains("Windows")) {
                p = Runtime.getRuntime().exec(
                        currentDir + pathSeperator + "Drivers" + pathSeperator + filename + ".bat"
                );
            } else {
                p = Runtime.getRuntime().exec(
                        "sh " + currentDir + pathSeperator + "Drivers" + pathSeperator + filename + ".sh"
                );
            }

            p.waitFor();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* =========================================================
       FAILED NODE PARSING
       ========================================================= */

    public static void CreateFailNodes(String strMain) {

        String[] arrSplit = strMain.split(",");
        int i = 1;

        while (i < arrSplit.length) {

            if (arrSplit[i].contains("vertexName")) {

                String name = arrSplit[i]
                        .substring(arrSplit[i].indexOf(':') + 2)
                        .replace("\"", "");

                failedVertexName[countVertxFailed++] = name;
                i++;
            } else if (arrSplit[i].contains("edgeId")) {

                String edge = arrSplit[i + 1]
                        .substring(arrSplit[i + 1].indexOf(':') + 2)
                        .replace("\"", "")
                        .replace("}", "")
                        .replace("]", "");

                failedEdgeName[countEdgeFailed++] = edge;
                i++;
            }

            i++;
        }
    }
}
