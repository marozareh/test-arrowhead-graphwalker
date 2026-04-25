package com.mbtroads.ai;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeepModelLLM {

    public static String analyze(ModelExecutionSnapshot snapshot,
                                 boolean hasCycle,
                                 int unreachable,
                                 int selfLoops) throws Exception {

        // ================= PROMPT =================

        String prompt =
                "You are a senior Model-Based Testing architect.\n\n" +

                        "Provide a professional structural risk analysis.\n" +
                        "Respond in structured readable sections.\n" +
                        "Use bullet points starting with '-'.\n" +
                        "No markdown formatting.\n" +
                        "No bold.\n" +
                        "No asterisks.\n\n" +

                        "Model: " + snapshot.modelName + "\n" +
                        "Total Vertices: " + snapshot.totalVertices + "\n" +
                        "Total Edges: " + snapshot.totalEdges + "\n" +
                        "Vertex Coverage: " + snapshot.getVertexCoveragePercent() + "%\n" +
                        "Edge Coverage: " + snapshot.getEdgeCoveragePercent() + "%\n" +
                        "Has Cycle: " + hasCycle + "\n" +
                        "Unreachable Vertices: " + unreachable + "\n" +
                        "Self Loops: " + selfLoops + "\n\n" +

                        "Structure the answer exactly as:\n" +
                        "Structural Risk Assessment:\n" +
                        "- ...\n\n" +
                        "Identified Risks:\n" +
                        "- ...\n\n" +
                        "Improvement Suggestions:\n" +
                        "- ...\n\n" +
                        "Testing Recommendations:\n" +
                        "- ...\n";

        // ================= HTTP CALL =================

        URL url = new URL("http://localhost:11434/api/generate");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        String safePrompt = prompt
                .replace("\"", "\\\"")
                .replace("\n", "\\n");

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
            throw new RuntimeException("LLM HTTP error: " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );

        StringBuilder response = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            response.append(line);
        }

        conn.disconnect();

        // ================= JSON EXTRACTION =================

        String json = response.toString();

        int start = json.indexOf("\"response\":\"");
        int end = json.indexOf("\",\"done\":");

        if (start == -1 || end == -1) {
            return "LLM returned unexpected format.";
        }

        String result = json.substring(start + 12, end);

        // ================= CLEAN OUTPUT =================

        result = result
                .replace("\\n", "\n")
                .replace("\\t", "")
                .replace("\\\"", "\"");

        // Remove markdown leftovers
        result = result
                .replace("**", "")
                .replace("* ", "- ")
                .replace("+ ", "- ");

        // Ensure bullets start on new lines
        result = result.replaceAll("(?m)^\\s*-", "\n-");

        // Clean excessive blank lines
        result = result.replaceAll("\\n{3,}", "\n\n");

        return result.trim();
    }
}
