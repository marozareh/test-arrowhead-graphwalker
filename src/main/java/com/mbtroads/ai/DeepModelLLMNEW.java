package com.mbtroads.ai;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeepModelLLMNEW {

    public enum Mode {
        STRUCTURAL_EVALUATION,
        THEORETICAL_ANALYSIS,
        GAP_DETECTION
    }

    public static String analyze(ModelExecutionSnapshot snapshot,
                                 boolean hasCycle,
                                 int unreachable,
                                 int selfLoops,
                                 Mode mode,
                                 String apiSummary) throws Exception {

        String prompt = buildPrompt(snapshot, hasCycle, unreachable, selfLoops, mode, apiSummary);
        return callLLM(prompt);
    }

    // =========================================================
    // PROMPT BUILDER
    // =========================================================

    private static String buildPrompt(ModelExecutionSnapshot snapshot,
                                      boolean hasCycle,
                                      int unreachable,
                                      int selfLoops,
                                      Mode mode,
                                      String apiSummary) {

        String baseMetrics =
                "Model: " + snapshot.modelName + "\n" +
                        "Total Vertices: " + snapshot.totalVertices + "\n" +
                        "Total Edges: " + snapshot.totalEdges + "\n" +
                        "Vertex Coverage: " + snapshot.getVertexCoveragePercent() + "%\n" +
                        "Edge Coverage: " + snapshot.getEdgeCoveragePercent() + "%\n" +
                        "Has Cycle: " + hasCycle + "\n" +
                        "Unreachable Vertices: " + unreachable + "\n" +
                        "Self Loops: " + selfLoops + "\n\n";

        if (mode == Mode.STRUCTURAL_EVALUATION) {

            return
                    "You are a researcher in Model-Based Testing.\n\n" +
                            "Analyze the GraphWalker test model strictly from a Model-Based Testing perspective.\n\n" +
                            "Do NOT discuss cascading failures, system architecture, distributed systems, or fault tolerance.\n\n" +
                            "Focus only on:\n" +
                            "- state reachability\n" +
                            "- transition determinism\n" +
                            "- path completeness\n" +
                            "- lifecycle modeling\n" +
                            "- test oracle strength\n" +
                            "- modeling redundancy\n" +
                            "- guard conditions\n\n" +
                            "Use formal MBT terminology.\n" +
                            "Respond in structured bullet points.\n\n" +
                            baseMetrics;

        } else if (mode == Mode.THEORETICAL_ANALYSIS) {

            return
                    "You are an academic researcher in Model-Based Testing.\n\n" +
                            "Provide a formal theoretical evaluation of the model.\n\n" +
                            "Discuss:\n" +
                            "- structural soundness\n" +
                            "- behavioral determinism\n" +
                            "- lifecycle completeness\n" +
                            "- transition ambiguity\n" +
                            "- coverage adequacy\n\n" +
                            "Do NOT use bullet points.\n" +
                            "Use academic language suitable for a master's thesis.\n\n" +
                            baseMetrics;

        } else if (mode == Mode.GAP_DETECTION) {

            return
                    "You are an expert in API testing and Model-Based Testing.\n\n" +
                            "Your task is to detect behavioral gaps between a GraphWalker MBT model and an OpenAPI specification.\n\n" +
                            "Analyze ONLY test coverage and modeling completeness.\n" +
                            "Do NOT provide generic software engineering advice.\n\n" +
                            "Identify missing test scenarios in these categories:\n\n" +
                            "Missing Endpoints:\n" +
                            "- ...\n\n" +
                            "Missing Response Codes:\n" +
                            "- ...\n\n" +
                            "Missing Negative Tests:\n" +
                            "- ...\n\n" +
                            "Missing Lifecycle Tests:\n" +
                            "- ...\n\n" +
                            "Missing Security Tests:\n" +
                            "- ...\n\n" +
                            "Current Model Metrics:\n" +
                            baseMetrics +
                            "\nOpenAPI Summary:\n" +
                            (apiSummary == null ? "Not provided.\n" : apiSummary + "\n");

        }

        return baseMetrics;
    }

    // =========================================================
    // LLM CALL
    // =========================================================

    private static String callLLM(String prompt) throws Exception {

        URL url = new URL("http://127.0.0.1:11434/api/generate");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        String safePrompt = prompt
                .replace("\"", "\\\"")
                .replace("\n", "\\n");

        String body =
                "{"
                        + "\"model\":\"phi3\","
                        + "\"prompt\":\"" + safePrompt + "\","
                        + "\"stream\":false,"
                        + "\"options\":{"
                        + "\"temperature\":0.2"
                        + "}"
                        + "}";

        try (OutputStream os = conn.getOutputStream()) {
            os.write(body.getBytes("UTF-8"));
        }

        int status = conn.getResponseCode();

        BufferedReader br = (status == 200)
                ? new BufferedReader(new InputStreamReader(conn.getInputStream()))
                : new BufferedReader(new InputStreamReader(conn.getErrorStream()));

        StringBuilder fullText = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            // each line is a JSON object → extract "response"
            int start = line.indexOf("\"response\":\"");
            int end = line.indexOf("\",\"done\":");

            if (start != -1 && end != -1) {
                String part = line.substring(start + 12, end)
                        .replace("\\n", "\n")
                        .replace("\\\"", "\"");
                fullText.append(part);
            }
        }

        conn.disconnect();

        if (status != 200) {
            throw new RuntimeException("LLM HTTP error: " + status + " → " + fullText);
        }

        return fullText.toString().trim();
    }

    // =========================================================
    // RESPONSE EXTRACTION
    // =========================================================

    private static String extractResponse(String json) {

        int start = json.indexOf("\"response\":\"");
        int end = json.indexOf("\",\"done\":");

        if (start == -1 || end == -1) {
            return "LLM returned unexpected format.";
        }

        String result = json.substring(start + 12, end);

        return result
                .replace("\\n", "\n")
                .replace("\\t", "")
                .replace("\\\"", "\"")
                .replaceAll("\\n{3,}", "\n\n")
                .trim();
    }

    // =========================================================
    // OPTIONAL: Backward Compatible Call
    // =========================================================

    public static String analyze(ModelExecutionSnapshot snapshot,
                                 boolean hasCycle,
                                 int unreachable,
                                 int selfLoops) throws Exception {

        return analyze(snapshot,
                hasCycle,
                unreachable,
                selfLoops,
                Mode.STRUCTURAL_EVALUATION,
                null);
    }
}