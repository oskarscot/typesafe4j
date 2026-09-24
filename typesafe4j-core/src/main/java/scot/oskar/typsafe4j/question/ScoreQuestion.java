package scot.oskar.typsafe4j.question;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/// A question that produces a numeric score from the given criteria.
///
/// @param instructions the question instructions
/// @param criteria the scoring criteria
public record ScoreQuestion(String instructions, List<String> criteria) implements Question {

    /// Creates a scoring question builder.
    ///
    /// @return a new builder
    public static ScoreQuestionBuilder builder() {
        return new ScoreQuestionBuilder();
    }

    /// Builds a [ScoreQuestion] from instructions and scoring criteria.
    public static class ScoreQuestionBuilder {

        private String instructions;
        private List<String> criteria;

        /// Creates a builder with no instructions or criteria.
        public ScoreQuestionBuilder() { }

        /// Sets the question instructions.
        ///
        /// @param instructions the question instructions
        /// @return this builder
        public ScoreQuestionBuilder instructions(String instructions) {
            this.instructions = instructions;
            return this;
        }

        /// Sets the scoring criteria, replacing any previous criteria.
        ///
        /// @param criteria the scoring criteria
        /// @return this builder
        public ScoreQuestionBuilder criteria(List<String> criteria) {
            this.criteria = criteria;
            return this;
        }

        /// Sets the scoring criteria, replacing any previous criteria.
        ///
        /// @param criteria the scoring criteria
        /// @return this builder
        public ScoreQuestionBuilder criteria(String... criteria) {
            this.criteria = Arrays.asList(criteria);
            return this;
        }

        /// Sets a single scoring criterion, replacing any previous criteria.
        ///
        /// @param criteria the scoring criterion
        /// @return this builder
        public ScoreQuestionBuilder criteria(String criteria) {
            this.criteria = Collections.singletonList(criteria);
            return this;
        }

        /// Creates a question with the configured instructions and criteria.
        ///
        /// @return the question
        public ScoreQuestion build() {
            return new ScoreQuestion(instructions, criteria);
        }
    }
}
