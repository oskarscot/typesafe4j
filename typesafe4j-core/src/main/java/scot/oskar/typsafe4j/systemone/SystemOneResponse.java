package scot.oskar.typsafe4j.systemone;

import scot.oskar.typsafe4j.answer.*;

import java.util.Map;

/// Answers and token usage returned by System One.
///
/// @param model the model that produced the answers
/// @param answers answers keyed by question identifier
/// @param usage the reported token usage
public record SystemOneResponse(
    String model,
    Map<String, Answer> answers,
    TokenUsage usage
) {

    /// Returns a yes/no answer by question identifier.
    ///
    /// @param name the question identifier
    /// @return the yes/no answer
    /// @throws IllegalArgumentException if no answer exists for the identifier
    /// @throws IllegalStateException if the answer is not a [NoulAnswer]
    public NoulAnswer noul(String name) {
        return as(name, NoulAnswer.class);
    }

    /// Returns a choice answer by question identifier.
    ///
    /// @param name the question identifier
    /// @return the choice answer
    /// @throws IllegalArgumentException if no answer exists for the identifier
    /// @throws IllegalStateException if the answer is not a [ChoiceAnswer]
    public ChoiceAnswer choice(String name) {
        return as(name, ChoiceAnswer.class);
    }

    /// Returns a score answer by question identifier.
    ///
    /// @param name the question identifier
    /// @return the score answer
    /// @throws IllegalArgumentException if no answer exists for the identifier
    /// @throws IllegalStateException if the answer is not a [ScoreAnswer]
    public ScoreAnswer score(String name) {
        return as(name, ScoreAnswer.class);
    }

    /// Returns an answer by question identifier.
    ///
    /// @param name the question identifier
    /// @return the answer
    /// @throws IllegalArgumentException if no answer exists for the identifier
    public Answer answer(String name) {
        var answer = answers.get(name);

        if(answer == null) {
            throw new IllegalArgumentException("Answer map does not contain '%s'".formatted(name));
        }

        return answer;
    }

    /// Returns an answer as the requested type.
    ///
    /// @param <T> the expected answer type
    /// @param name the question identifier
    /// @param actual the expected answer class
    /// @return the answer cast to the requested type
    /// @throws IllegalArgumentException if no answer exists for the identifier
    /// @throws IllegalStateException if the answer has a different type
    public <T extends Answer> T as(String name, Class<T> actual) {
        var answer = answer(name);

        if(!actual.isInstance(answer)) {
            throw new IllegalStateException("%s cannot be assigned to type %s".formatted(name, actual.getSimpleName()));
        }

        return actual.cast(answer);
    }
}
