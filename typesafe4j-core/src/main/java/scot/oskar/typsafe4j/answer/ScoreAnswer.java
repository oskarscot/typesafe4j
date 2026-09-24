package scot.oskar.typsafe4j.answer;

import java.util.Map;

/// A numeric score with confidence and scoring details.
///
/// @param score the returned score
/// @param confidence the confidence in the score
/// @param legend descriptions keyed by score value
/// @param probabilities the probabilities reported for the scoring options
public record ScoreAnswer(
        double score,
        double confidence,
        Map<Integer, String> legend,
        Map<String, Double> probabilities
) implements Answer {

}
