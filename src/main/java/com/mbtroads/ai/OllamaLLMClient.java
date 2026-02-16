package com.mbtroads.ai;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class OllamaLLMClient {

    private static final String OLLAMA_URL = "http://localhost:11434/api/generate";

    // =========================================================
    // MAIN ENTRY
    // =========================================================
    public static String runLLM(ModelExecutionSnapshot snapshot) throws Exception {

        String modelJson = readModelJson(snapshot.modelName);

        String prompt =
                "You are a senior Model Based Testing architect.\n\n" +
                        "Below is the REAL GraphWalker model JSON:\n\n" +
                        modelJson + "\n\n" +
                        "Execution Information:\n" +
                        "Visited Vertices: " + snapshot.visitedVertices.size() + "\n" +
                        "Visited Edges: " + snapshot.visitedEdges.size() + "\n" +
                        "Has Failure: " + snapshot.hasFailure + "\n\n" +
                        "Perform deep structural analysis:\n" +
                        "1) Coverage gaps\n" +
                        "2) Unreachable states\n" +
                        "3) Risky transitions\n" +
                        "4) Guard weaknesses\n" +
                        "5) Production risk estimation\n" +
                        "6) Concrete improvement suggestions\n";

        String jsonBody =
                "{"
                        + "\"model\":\"llama3:latest\","
                        + "\"prompt\":\"" + escapeJson(prompt) + "\","
                        + "\"stream\":false"
                        + "}";

        URL url = new URL(OLLAMA_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        OutputStream os = conn.getOutputStream();
        os.write(jsonBody.getBytes("UTF-8"));
        os.close();

        int responseCode = conn.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("LLM error: HTTP " + responseCode);
        }

        BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "UTF-8")
        );

        StringBuilder rawResponse = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            rawResponse.append(line);
        }

        br.close();
        conn.disconnect();

        return extractResponse(rawResponse.toString());
    }

    // =========================================================
    // READ GRAPHWALKER MODEL JSON
    // =========================================================
    private static String readModelJson(String modelName) throws Exception {

        String path = System.getProperty("user.dir")
                + "/src/main/resources/graphwalker/"
                + modelName + ".json";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        reader.close();

        // Optional: limit size to avoid token overload
        if (sb.length() > 15000) {
            return sb.substring(0, 15000);
        }

        return sb.toString();
    }

    // =========================================================
    // EXTRACT ONLY LLM TEXT FROM OLLAMA RESPONSE JSON
    // =========================================================
    private static String extractResponse(String json) {

        try {
            int start = json.indexOf("\"response\":\"");
            if (start == -1) {
                return json;
            }

            start += 12;
            int end = json.indexOf("\",\"done\"", start);

            if (end == -1) {
                return json;
            }

            return json.substring(start, end)
                    .replace("\\n", "\n")
                    .replace("\\\"", "\"");

        } catch (Exception e) {
            return json;
        }
    }

    // =========================================================
    // SAFE JSON ESCAPE
    // =========================================================
    private static String escapeJson(String text) {
        return text
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "");
    }
}
