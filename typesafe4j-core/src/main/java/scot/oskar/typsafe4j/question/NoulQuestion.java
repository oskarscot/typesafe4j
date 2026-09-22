package scot.oskar.typsafe4j.question;

import com.fasterxml.jackson.annotation.JsonInclude;

public record NoulQuestion(
            String instructions,
            @JsonInclude(JsonInclude.Include.NON_NULL) NoulCriteria criteria
    ) implements Question {

        public static NoulQuestion basic(String instructions) {
            return new NoulQuestion(instructions, null);
        }
    }