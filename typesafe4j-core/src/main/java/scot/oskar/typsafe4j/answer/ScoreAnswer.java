package scot.oskar.typsafe4j.answer;

import java.util.Map;

public record ScoreAnswer(
        double score,
        double confidence,
        Map<Integer, String> legend,
        Map<String, Double> probabilities
) implements Answer {

}
