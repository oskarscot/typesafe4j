package scot.oskar.typsafe4j.question;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public record ScoreQuestion(String instructions, List<String> criteria) implements Question {

    public static ScoreQuestionBuilder builder() {
        return new ScoreQuestionBuilder();
    }

    public static class ScoreQuestionBuilder {

        private String instructions;
        private List<String> criteria;

        public ScoreQuestionBuilder instructions(String instructions) {
            this.instructions = instructions;
            return this;
        }

        public ScoreQuestionBuilder criteria(List<String> criteria) {
            this.criteria = criteria;
            return this;
        }

        public ScoreQuestionBuilder criteria(String... criteria) {
            this.criteria = Arrays.asList(criteria);
            return this;
        }

        public ScoreQuestionBuilder criteria(String criteria) {
            this.criteria = Collections.singletonList(criteria);
            return this;
        }

        public ScoreQuestion build() {
            return new ScoreQuestion(instructions, criteria);
        }
    }
}
