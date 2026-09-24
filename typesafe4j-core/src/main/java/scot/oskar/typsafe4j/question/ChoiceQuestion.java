package scot.oskar.typsafe4j.question;

import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;

/// A question that selects one of the named choices.
///
/// @param instructions the question instructions
/// @param criteria descriptions keyed by choice name
public record ChoiceQuestion(String instructions, Map<String, String> criteria) implements Question {

    /// Creates a choice question builder.
    ///
    /// @return a new builder
    public static ChoiceQuestionBuilder builder() {
        return new ChoiceQuestionBuilder();
    }

    /// Builds a [ChoiceQuestion] from instructions and named choices.
    public static class ChoiceQuestionBuilder {

        private final Map<String, String> criteria = new HashMap<>();
        private String instructions;

        /// Creates a builder with no choices or instructions.
        public ChoiceQuestionBuilder() { }

        /// Sets the question instructions.
        ///
        /// @param instructions the question instructions
        /// @return this builder
        public ChoiceQuestionBuilder withInstructions(@NonNull String instructions) {
            this.instructions = instructions;
            return this;
        }

        /// Adds a choice, replacing any description for the same key.
        ///
        /// @param key the choice name
        /// @param value the choice description
        /// @return this builder
        public ChoiceQuestionBuilder withCriteria(@NonNull String key, @NonNull String value) {
            this.criteria.put(key, value);
            return this;
        }

        /// Adds choices, replacing descriptions for matching keys.
        ///
        /// @param criteria descriptions keyed by choice name
        /// @return this builder
        public ChoiceQuestionBuilder withCriteria(@NonNull Map<String, String> criteria) {
            this.criteria.putAll(criteria);
            return this;
        }

        /// Creates a question with the configured instructions and choices.
        ///
        /// @return the question
        public ChoiceQuestion build() {
            return new ChoiceQuestion(instructions, criteria);
        }
    }
}
