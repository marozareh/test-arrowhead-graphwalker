package com.mbtroads.ai;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ModelLLMEngine {

    public static String ask(String prompt) {

        try {

            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            String json =
                    "{"
                            + "\"model\":\"llama3\","
                            + "\"prompt\":\"" + prompt.replace("\"", "\\\"") + "\","
                            + "\"stream\":false"
                            + "}";

            OutputStream os = con.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();

            BufferedReader br =
                    new BufferedReader(new InputStreamReader(con.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            br.close();

            return response.toString();

        } catch (Exception e) {
            return "LLM error: " + e.getMessage();
        }
    }
}
