package scot.oskar.typsafe4j.systemone;

public sealed interface Question permits Question.ChoiceQuestion, Question.NoulQuestion {

    record NoulQuestion(String instructions, NoulCriteria criteria) implements Question {

        public static NoulQuestion basic(String instructions) {
            return new NoulQuestion(instructions, null);
        }
    }

    record ChoiceQuestion(String instructions) implements Question {}
}
