package scot.oskar.typsafe4j.systemone;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NoulCriteria(
        @JsonProperty("true") String correct,
        @JsonProperty("false") String incorrect
) { }
