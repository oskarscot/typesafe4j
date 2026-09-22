package scot.oskar.typsafe4j.question;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NoulCriteria(
        @JsonProperty("true") String correct,
        @JsonProperty("false") String incorrect
) { }
