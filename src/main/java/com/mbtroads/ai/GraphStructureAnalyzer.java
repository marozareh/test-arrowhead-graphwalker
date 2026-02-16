package com.mbtroads.ai;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.*;

public class GraphStructureAnalyzer {

    private final Map<String, List<String>> adjacencyList = new HashMap<>();
    private final Set<String> vertices = new HashSet<>();

    private GraphStructureAnalyzer() {}

    /* =========================================================
       FACTORY METHOD
       ========================================================= */

    public static GraphStructureAnalyzer fromJsonFile(String path) {

        try {

            JSONParser parser = new JSONParser();
            JSONObject root =
                    (JSONObject) parser.parse(new FileReader(path));

            JSONArray models = (JSONArray) root.get("models");
            JSONObject model = (JSONObject) models.get(0);

            GraphStructureAnalyzer analyzer =
                    new GraphStructureAnalyzer();

            // ---- Load vertices
            JSONArray vertexArray =
                    (JSONArray) model.get("vertices");

            for (Object obj : vertexArray) {
                JSONObject v = (JSONObject) obj;
                String name = (String) v.get("name");

                analyzer.vertices.add(name);
                analyzer.adjacencyList.put(name, new ArrayList<>());
            }

            // ---- Load edges
            JSONArray edges =
                    (JSONArray) model.get("edges");

            Map<String, String> idToName = new HashMap<>();

            for (Object obj : vertexArray) {
                JSONObject v = (JSONObject) obj;
                idToName.put(
                        (String) v.get("id"),
                        (String) v.get("name")
                );
            }

            for (Object obj : edges) {
                JSONObject edge = (JSONObject) obj;

                String source =
                        idToName.get(edge.get("sourceVertexId"));

                String target =
                        idToName.get(edge.get("targetVertexId"));

                analyzer.adjacencyList
                        .get(source)
                        .add(target);
            }

            return analyzer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* =========================================================
       CYCLE DETECTION (DFS)
       ========================================================= */

    public boolean hasCycle() {

        Set<String> visited = new HashSet<>();
        Set<String> recursionStack = new HashSet<>();

        for (String vertex : vertices) {
            if (dfsCycle(vertex, visited, recursionStack)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfsCycle(
            String current,
            Set<String> visited,
            Set<String> stack
    ) {

        if (stack.contains(current)) return true;
        if (visited.contains(current)) return false;

        visited.add(current);
        stack.add(current);

        for (String neighbor :
                adjacencyList.getOrDefault(current, Collections.emptyList())) {

            if (dfsCycle(neighbor, visited, stack)) {
                return true;
            }
        }

        stack.remove(current);
        return false;
    }

    /* =========================================================
       UNREACHABLE FROM START
       ========================================================= */

    public int countUnreachableVertices(String startVertex) {

        if (!vertices.contains(startVertex)) {
            throw new IllegalArgumentException(
                    "Start vertex not found: " + startVertex
            );
        }

        Set<String> visited = new HashSet<>();
        dfsReach(startVertex, visited);

        return vertices.size() - visited.size();
    }

    private void dfsReach(String current, Set<String> visited) {

        if (visited.contains(current)) return;

        visited.add(current);

        for (String neighbor :
                adjacencyList.getOrDefault(current, Collections.emptyList())) {

            dfsReach(neighbor, visited);
        }
    }

    /* =========================================================
       SELF LOOPS
       ========================================================= */

    public int countSelfLoops() {

        int count = 0;

        for (String vertex : vertices) {
            for (String neighbor :
                    adjacencyList.getOrDefault(vertex, Collections.emptyList())) {

                if (vertex.equals(neighbor)) {
                    count++;
                }
            }
        }

        return count;
    }
}
