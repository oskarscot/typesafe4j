package scot.oskar.typsafe4j.question;

import com.fasterxml.jackson.annotation.JsonInclude;

/// A yes/no question with optional criteria for each outcome.
///
/// @param instructions the question instructions
/// @param criteria the outcome criteria, or `null` to omit them
public record NoulQuestion(
        String instructions,
        @JsonInclude(JsonInclude.Include.NON_NULL) NoulCriteria criteria
) implements Question {

    /// Creates a yes/no question builder.
    ///
    /// @return a new builder
    public static NoulQuestionBuilder builder() {
        return new NoulQuestionBuilder();
    }

    /// Builds a [NoulQuestion] from instructions and optional criteria.
    public static class NoulQuestionBuilder {

        private String instructions;
        private NoulCriteria criteria;

        /// Sets the question instructions.
        ///
        /// @param instructions the question instructions
        /// @return this builder
        public NoulQuestionBuilder instructions(String instructions) {
            this.instructions = instructions;
            return this;
        }

        /// Sets the criteria for true and false answers.
        ///
        /// @param criteria the outcome criteria, or `null` to omit them
        /// @return this builder
        public NoulQuestionBuilder criteria(NoulCriteria criteria) {
            this.criteria = criteria;
            return this;
        }

        /// Creates a question with the configured instructions and criteria.
        ///
        /// @return the question
        public NoulQuestion build() {
            return new NoulQuestion(instructions, criteria);
        }
    }
}
