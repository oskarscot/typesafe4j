package scot.oskar.typsafe4j.systemone;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.model.Model;
import scot.oskar.typsafe4j.question.Question;

import java.util.HashMap;
import java.util.Map;

public record SystemOneRequest(
        @NonNull Object state,
        @NonNull String model,
        @NonNull @JsonProperty("questions") Map<String, Question> questionMap
) {

    public static SystemOneRequestBuilder builder() {
        return new SystemOneRequestBuilder();
    }

    public static class SystemOneRequestBuilder {

        private final Map<String, Question> questionMap = new HashMap<>();
        private String state;
        private String model = Model.JEV_LATEST.getModelAlias();

        public SystemOneRequestBuilder withSimpleState(@NonNull String state) {
            this.state = state;
            return this;
        }

        public SystemOneRequestBuilder withModel(@NonNull Model model) {
            this.model = model.getModelAlias();
            return this;
        }

        public SystemOneRequestBuilder withModel(@NonNull String model) {
            this.model = model;
            return this;
        }

        public SystemOneRequestBuilder withQuestion(@NonNull String questionId, @NonNull Question question) {
            this.questionMap.put(questionId, question);
            return this;
        }

        public SystemOneRequest build() {
            return new SystemOneRequest(state, model, questionMap);
        }
    }
}
