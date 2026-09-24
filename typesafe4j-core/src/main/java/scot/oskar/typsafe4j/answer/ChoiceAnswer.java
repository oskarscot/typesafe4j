package scot.oskar.typsafe4j.answer;

import java.util.Map;

/// The selected choice and its confidence.
///
/// @param choice the selected choice key
/// @param confidence the confidence in the selected choice
/// @param probabilities the probability of each choice
public record ChoiceAnswer(
        String choice,
        double confidence,
        Map<String, Double> probabilities
) implements Answer { }
