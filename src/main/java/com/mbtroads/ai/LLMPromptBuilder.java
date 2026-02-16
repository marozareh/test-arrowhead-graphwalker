package com.mbtroads.ai;

public class LLMPromptBuilder {

    public static String build(ModelExecutionSnapshot s) {

        return "Analyze the following GraphWalker model execution:\n\n" +
                "Model Name: " + s.modelName + "\n" +
                "Total Vertices: " + s.totalVertices + "\n" +
                "Total Edges: " + s.totalEdges + "\n" +
                "Visited Vertices: " + s.visitedVertices.size() + "\n" +
                "Visited Edges: " + s.visitedEdges.size() + "\n" +
                "Failure Occurred: " + s.hasFailure + "\n\n" +
                "Provide:\n" +
                "1. Architectural weaknesses\n" +
                "2. Missing negative paths\n" +
                "3. Risk analysis\n" +
                "4. Suggestions to improve model robustness";
    }
}
