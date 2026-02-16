package com.mbtroads.ai;

public class LLMAnalyzer {

    public static String runLLM(ModelExecutionSnapshot snapshot) {

        String prompt = LLMPromptBuilder.build(snapshot);
        return LLMClient.analyzeWithLLM(prompt);
    }
}
