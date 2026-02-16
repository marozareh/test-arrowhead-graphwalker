package com.mbtroads.ai;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class LocalLLMClient {

    public static String askLLM(String prompt) {

        try {
            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            String jsonInputString =
                    "{"
                            + "\"model\":\"llama3\","
                            + "\"prompt\":\"" + prompt.replace("\"", "\\\"") + "\","
                            + "\"stream\":false"
                            + "}";

            OutputStream os = con.getOutputStream();
            os.write(jsonInputString.getBytes("utf-8"));
            os.flush();
            os.close();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8")
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                response.append(line.trim());
            }

            br.close();

            return response.toString();

        } catch (Exception e) {
            return "Local LLM failed: " + e.getMessage();
        }
    }
}
