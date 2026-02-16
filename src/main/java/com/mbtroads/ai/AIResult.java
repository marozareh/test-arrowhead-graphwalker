package com.mbtroads.ai;

public class AIResult {

    public final String summary;
    public final String risks;
    public final String recommendations;
    public final int qualityScore;

    public AIResult(String summary,
                    String risks,
                    String recommendations,
                    int qualityScore) {
        this.summary = summary;
        this.risks = risks;
        this.recommendations = recommendations;
        this.qualityScore = qualityScore;
    }

    @Override
    public String toString() {
        return String.format(
                "MODEL QUALITY SCORE: %d/100\n\n" +
                        "SUMMARY:\n%s\n\n" +
                        "RISKS:\n%s\n\n" +
                        "RECOMMENDATIONS:\n%s\n",
                qualityScore,
                summary,
                risks,
                recommendations
        );
    }
}
