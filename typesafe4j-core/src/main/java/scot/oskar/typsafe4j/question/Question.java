package scot.oskar.typsafe4j.question;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = NoulQuestion.class, name = "noul"),
        @JsonSubTypes.Type(value = ChoiceQuestion.class, name = "choice"),
        @JsonSubTypes.Type(value = ScoreQuestion.class, name = "score")
})
public sealed interface Question permits ChoiceQuestion, NoulQuestion, ScoreQuestion { }
