package scot.oskar.typsafe4j.systemone;

import scot.oskar.typsafe4j.model.Model;

import java.util.HashMap;
import java.util.Map;

public record SystemOneRequest(Object state, String model) {

    public static SystemOneRequestBuilder builder() {
        return new SystemOneRequestBuilder();
    }

    public static class SystemOneRequestBuilder {

        private String state;
        private String model = Model.JEV_LATEST.getModelAlias();
        private Map<String, Question> questionMap = new HashMap<>();

        public SystemOneRequestBuilder withSimpleState(String state) {
            this.state = state;
            return this;
        }

        public SystemOneRequestBuilder withModel(Model model) {
            this.model = model.getModelAlias();
            return this;
        }

        public SystemOneRequestBuilder withModel(String model) {
            this.model = model;
            return this;
        }

        public SystemOneRequestBuilder withQuestion(String questionId, Question question) {
            this.questionMap.put(questionId, question);
            return this;
        }

        public SystemOneRequest build() {
            return new SystemOneRequest(state, model);
        }
    }
}
