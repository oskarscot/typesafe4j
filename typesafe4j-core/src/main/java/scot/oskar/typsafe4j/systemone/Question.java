package scot.oskar.typsafe4j.systemone;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;
import java.util.Map;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Question.NoulQuestion.class, name = "noul"),
        @JsonSubTypes.Type(value = Question.ChoiceQuestion.class, name = "choice"),
        @JsonSubTypes.Type(value = Question.ScoreQuestion.class, name = "score")
})
public sealed interface Question permits Question.ChoiceQuestion, Question.NoulQuestion, Question.ScoreQuestion {

    record NoulQuestion(
            String instructions,
            @JsonInclude(JsonInclude.Include.NON_NULL) NoulCriteria criteria
    ) implements Question {

        public static NoulQuestion basic(String instructions) {
            return new NoulQuestion(instructions, null);
        }
    }

    record ChoiceQuestion(String instructions, Map<String, String> criteria) implements Question {}

    record ScoreQuestion(String instructions, List<String> criteria) implements Question { }
}
