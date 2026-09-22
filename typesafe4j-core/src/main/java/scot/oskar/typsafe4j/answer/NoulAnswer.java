package scot.oskar.typsafe4j.answer;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NoulAnswer(
        @JsonProperty("noul") double confidence
) implements Answer {

    public boolean isTrue() {
        return confidence > 0.50d;
    }

}
