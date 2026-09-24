package scot.oskar.typsafe4j.answer;

import com.fasterxml.jackson.annotation.JsonProperty;

/// A yes/no answer expressed as confidence that the answer is true.
///
/// @param confidence the confidence that the answer is true
public record NoulAnswer(
        @JsonProperty("noul") double confidence
) implements Answer {

    /// Returns whether the confidence is greater than `0.5`.
    ///
    /// @return `true` if the confidence exceeds `0.5`
    public boolean isTrue() {
        return confidence > 0.50d;
    }

}
