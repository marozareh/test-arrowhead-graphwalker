package com.mbtroads.ai;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeepModelLLM {

    public static String analyze(ModelExecutionSnapshot snapshot,
                                 boolean hasCycle,
                                 int unreachable,
                                 int selfLoops) throws Exception {

        String prompt =
                "You are a senior Model-Based Testing architect.\n\n" +
                        "Model: " + snapshot.modelName + "\n" +
                        "Total Vertices: " + snapshot.totalVertices + "\n" +
                        "Total Edges: " + snapshot.totalEdges + "\n" +
                        "Vertex Coverage: " + snapshot.getVertexCoveragePercent() + "%\n" +
                        "Edge Coverage: " + snapshot.getEdgeCoveragePercent() + "%\n" +
                        "Has Cycle: " + hasCycle + "\n" +
                        "Unreachable Vertices: " + unreachable + "\n" +
                        "Self Loops: " + selfLoops + "\n\n" +
                        "Provide structural risk assessment and improvement suggestions.";

        URL url = new URL("http://localhost:11434/api/generate");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        String safePrompt =
                prompt.replace("\"", "\\\"").replace("\n", "\\n");

        String body =
                "{"
                        + "\"model\":\"llama3:latest\","
                        + "\"prompt\":\"" + safePrompt + "\","
                        + "\"stream\":false"
                        + "}";

        try (OutputStream os = conn.getOutputStream()) {
            os.write(body.getBytes("UTF-8"));
        }

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("LLM HTTP error");
        }

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

        StringBuilder response = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            response.append(line);
        }

        conn.disconnect();

        String json = response.toString();

        int start = json.indexOf("\"response\":\"");
        int end = json.indexOf("\",\"done\":");

        if (start != -1 && end != -1) {
            return json.substring(start + 12, end)
                    .replace("\\n", "\n");
        }

        return "Unexpected LLM format.";
    }
}
