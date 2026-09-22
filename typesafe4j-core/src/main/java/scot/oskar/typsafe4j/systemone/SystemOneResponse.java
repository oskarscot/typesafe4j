package scot.oskar.typsafe4j.systemone;

import scot.oskar.typsafe4j.answer.*;

import java.util.Map;

public record SystemOneResponse(
    String model,
    Map<String, Answer> answers,
    TokenUsage usage
) {

    public NoulAnswer noul(String name) {
        return as(name, NoulAnswer.class);
    }

    public ChoiceAnswer choice(String name) {
        return as(name, ChoiceAnswer.class);
    }

    public ScoreAnswer score(String name) {
        return as(name, ScoreAnswer.class);
    }

    public Answer answer(String name) {
        var answer = answers.get(name);

        if(answer == null) {
            throw new IllegalArgumentException("Answer map does not contain '%s'".formatted(name));
        }

        return answer;
    }

    public <T extends Answer> T as(String name, Class<T> actual) {
        var answer = answer(name);

        if(!actual.isInstance(answer)) {
            throw new IllegalStateException("%s cannot be assigned to type %s".formatted(name, actual.getSimpleName()));
        }

        return actual.cast(answer);
    }
}
