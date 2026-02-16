package com.mbtroads.ai;

public class AIAnalyzer {

    public static AIResult analyze(ModelExecutionSnapshot snapshot) {

        int score = ModelQualityScorer.score(snapshot);

        String summary = snapshot.hasFailure
                ? "Failures detected during model execution"
                : "Model executed successfully without failures";

        String risks;
        if (snapshot.visitedEdges.size() < snapshot.totalEdges) {
            risks = "Unvisited edges detected. Some behaviors are unvalidated.";
        } else {
            risks = "Low immediate risk. Coverage is high.";
        }

        String recommendations;
        if (score < 70) {
            recommendations = "Increase model complexity and add negative paths.";
        } else if (score < 90) {
            recommendations = "Add payload mutation and fault injection.";
        } else {
            recommendations = "Model is strong. Consider probabilistic edge weighting.";
        }

        return new AIResult(summary, risks, recommendations, score);
    }
}
