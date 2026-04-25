package com.mbtroads.ai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class OpenApiSummaryExtractor {

    public static String generateSummary(String openApiUrl) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        InputStream is = new URL(openApiUrl).openStream();
        JsonNode root = mapper.readTree(is);

        StringBuilder summary = new StringBuilder();

        JsonNode paths = root.get("paths");

        if (paths == null) {
            return "No paths found in OpenAPI specification.";
        }

        Iterator<Map.Entry<String, JsonNode>> pathIterator =
                paths.fields();

        while (pathIterator.hasNext()) {

            Map.Entry<String, JsonNode> pathEntry =
                    pathIterator.next();

            String path = pathEntry.getKey();
            JsonNode methods = pathEntry.getValue();

            Iterator<Map.Entry<String, JsonNode>> methodIterator =
                    methods.fields();

            while (methodIterator.hasNext()) {

                Map.Entry<String, JsonNode> methodEntry =
                        methodIterator.next();

                String method =
                        methodEntry.getKey().toUpperCase();

                JsonNode methodNode =
                        methodEntry.getValue();

                JsonNode responses =
                        methodNode.get("responses");

                summary.append(method)
                        .append(" ")
                        .append(path)
                        .append(" -> ");

                if (responses != null) {

                    Iterator<String> responseCodes =
                            responses.fieldNames();

                    while (responseCodes.hasNext()) {

                        summary.append(responseCodes.next());

                        if (responseCodes.hasNext()) {
                            summary.append(", ");
                        }
                    }
                }

                summary.append("\n");
            }
        }

        return summary.toString();
    }
}