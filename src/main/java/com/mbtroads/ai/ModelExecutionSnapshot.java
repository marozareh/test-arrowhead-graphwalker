package com.mbtroads.ai;

import java.util.Set;

public class ModelExecutionSnapshot {

    public final String modelName;
    public final int totalVertices;
    public final int totalEdges;
    public final Set<String> visitedVertices;
    public final Set<String> visitedEdges;
    public final boolean hasFailure;

    public ModelExecutionSnapshot(
            String modelName,
            int totalVertices,
            int totalEdges,
            Set<String> visitedVertices,
            Set<String> visitedEdges,
            boolean hasFailure
    ) {
        this.modelName = modelName;
        this.totalVertices = totalVertices;
        this.totalEdges = totalEdges;
        this.visitedVertices = visitedVertices;
        this.visitedEdges = visitedEdges;
        this.hasFailure = hasFailure;
    }

    public double getVertexCoveragePercent() {
        return (double) visitedVertices.size() / totalVertices * 100;
    }

    public double getEdgeCoveragePercent() {
        return (double) visitedEdges.size() / totalEdges * 100;
    }

    public double computeDensity() {
        if (totalVertices <= 1) return 0;
        return (double) totalEdges /
                (totalVertices * (totalVertices - 1));
    }

    public double computeStructuralRisk(boolean hasCycle,
                                        int unreachable,
                                        int selfLoops) {

        double risk = 0;

        if (hasCycle) risk += 20;
        risk += unreachable * 5;
        risk += selfLoops * 10;

        if (getEdgeCoveragePercent() < 100) risk += 15;
        if (hasFailure) risk += 30;

        return Math.min(risk, 100);
    }

    public double computeQualityScore(boolean hasCycle,
                                      int unreachable,
                                      int selfLoops) {

        double quality = 100;

        if (hasCycle) quality -= 10;
        quality -= unreachable * 5;
        quality -= selfLoops * 5;

        if (hasFailure) quality -= 20;

        return Math.max(quality, 0);
    }
}
