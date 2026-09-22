package scot.oskar.typsafe4j.answer;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenUsage(
        @JsonProperty("input_tokens") int inputTokens,
        @JsonProperty("output_tokens") int outputTokens
) { }
