package com.mbtroads.ai;

import java.util.*;

public class CoverageTracker {

    private static final Map<String, Set<Integer>> coverage = new HashMap<>();

    public static void record(String method, String path, int status) {
        String key = method + " " + path;

        coverage.computeIfAbsent(key, k -> new HashSet<>())
                .add(status);
    }

    public static String generateSummary() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Set<Integer>> entry : coverage.entrySet()) {
            sb.append(entry.getKey()).append(" -> ");

            Iterator<Integer> it = entry.getValue().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) sb.append(", ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    public static void clear() {
        coverage.clear();
    }
}