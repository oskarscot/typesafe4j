package scot.oskar.typsafe4j.systemone;

import scot.oskar.typsafe4j.model.Model;

public class SystemOneRequest {

    private final String state;
    private final String model;

    public SystemOneRequest(String state, String model) {

    }

    static SystemOneRequestBuilder builder() {
        return new SystemOneRequestBuilder();
    }

    static class SystemOneRequestBuilder {

        private String model = Model.JEV_LATEST.getModelAlias();
        private String state;

        public SystemOneRequestBuilder withState(String state) {
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

        public SystemOneRequest build() {
            return new SystemOneRequest(state, model);
        }
    }
}
