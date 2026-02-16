package com.mbtroads.ai;

import okhttp3.*;
import java.io.IOException;

public class LLMClient {

    private static final String API_KEY = System.getenv("OPENAI_API_KEY");
    private static final String URL = "https://api.openai.com/v1/chat/completions";

    public static String analyzeWithLLM(String prompt) {

        try {
            OkHttpClient client = new OkHttpClient();

            String jsonBody =
                    "{\n" +
                            "  \"model\": \"gpt-4o-mini\",\n" +
                            "  \"messages\": [\n" +
                            "    {\"role\": \"system\", \"content\": \"You are an expert model-based testing architect.\"},\n" +
                            "    {\"role\": \"user\", \"content\": \"" + escape(prompt) + "\"}\n" +
                            "  ],\n" +
                            "  \"temperature\": 0.2\n" +
                            "}";

            Request request = new Request.Builder()
                    .url(URL)
                    .addHeader("Authorization", "Bearer " + API_KEY)
                    .addHeader("Content-Type", "application/json")
                    .post(RequestBody.create(jsonBody, MediaType.parse("application/json")))
                    .build();

            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                return "LLM request failed: " + response.code();
            }

            return response.body().string();

        } catch (IOException e) {
            return "LLM execution failed: " + e.getMessage();
        }
    }

    private static String escape(String text) {
        return text.replace("\"", "\\\"").replace("\n", "\\n");
    }
}
