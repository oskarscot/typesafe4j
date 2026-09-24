package scot.oskar.typsafe4j.question;

import com.fasterxml.jackson.annotation.JsonProperty;

/// Describes when a yes/no answer should be true or false.
///
/// @param correct the criteria for a true answer
/// @param incorrect the criteria for a false answer
public record NoulCriteria(
        @JsonProperty("true") String correct,
        @JsonProperty("false") String incorrect
) { }
