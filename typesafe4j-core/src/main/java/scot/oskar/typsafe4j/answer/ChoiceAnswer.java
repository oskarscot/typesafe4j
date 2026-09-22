package scot.oskar.typsafe4j.answer;

import java.util.Map;

public record ChoiceAnswer(
        String choice,
        double confidence,
        Map<String, Double> probabilities
) implements Answer { }
