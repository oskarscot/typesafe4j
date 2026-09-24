package scot.oskar.typsafe4j.question;

import com.fasterxml.jackson.annotation.JsonInclude;

public record NoulQuestion(
        String instructions,
        @JsonInclude(JsonInclude.Include.NON_NULL) NoulCriteria criteria
) implements Question {

    public static NoulQuestionBuilder builder() {
        return new NoulQuestionBuilder();
    }

    public static class NoulQuestionBuilder {

        private String instructions;
        private NoulCriteria criteria;

        public NoulQuestionBuilder instructions(String instructions) {
            this.instructions = instructions;
            return this;
        }

        public NoulQuestionBuilder criteria(NoulCriteria criteria) {
            this.criteria = criteria;
            return this;
        }

        public NoulQuestion build() {
            return new NoulQuestion(instructions, criteria);
        }
    }
}