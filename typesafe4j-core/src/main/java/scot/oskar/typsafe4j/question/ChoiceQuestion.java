package scot.oskar.typsafe4j.question;

import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;

public record ChoiceQuestion(String instructions, Map<String, String> criteria) implements Question {

    public static ChoiceQuestionBuilder builder() {
        return new ChoiceQuestionBuilder();
    }

    public static class ChoiceQuestionBuilder {

        private final Map<String, String> criteria = new HashMap<>();
        private String instructions;


        public ChoiceQuestionBuilder withInstructions(@NonNull String instructions) {
            this.instructions = instructions;
            return this;
        }

        public ChoiceQuestionBuilder withCriteria(@NonNull String key, @NonNull String value) {
            this.criteria.put(key, value);
            return this;
        }

        public ChoiceQuestionBuilder withCriteria(@NonNull Map<String, String> criteria) {
            this.criteria.putAll(criteria);
            return this;
        }

        public ChoiceQuestion build() {
            return new ChoiceQuestion(instructions, criteria);
        }
    }
}
