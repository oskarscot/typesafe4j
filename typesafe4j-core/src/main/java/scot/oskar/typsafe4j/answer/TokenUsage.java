package scot.oskar.typsafe4j.answer;

import com.fasterxml.jackson.annotation.JsonProperty;

/// Token counts reported for a request.
///
/// @param inputTokens the number of input tokens
/// @param outputTokens the number of output tokens
public record TokenUsage(
        @JsonProperty("input_tokens") int inputTokens,
        @JsonProperty("output_tokens") int outputTokens
) { }
