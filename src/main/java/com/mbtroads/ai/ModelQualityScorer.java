package com.mbtroads.ai;

public class ModelQualityScorer {

    public static int score(ModelExecutionSnapshot s) {

        if (s.totalVertices == 0 || s.totalEdges == 0) {
            return 0;
        }

        double vertexCoverage =
                (double) s.visitedVertices.size() / s.totalVertices;

        double edgeCoverage =
                (double) s.visitedEdges.size() / s.totalEdges;

        int score = 0;
        score += (int) (vertexCoverage * 50);
        score += (int) (edgeCoverage * 40);

        if (!s.hasFailure) {
            score += 10; // stability bonus
        }

        return Math.min(score, 100);
    }
}
