package scot.oskar.typsafe4j.systemone;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.model.Model;
import scot.oskar.typsafe4j.question.Question;

import java.util.HashMap;
import java.util.Map;

/// State and named questions to evaluate with a System One model.
///
/// @param state the context to evaluate, serialised as JSON
/// @param model the model alias
/// @param questionMap questions keyed by their identifiers
public record SystemOneRequest(
        @NonNull Object state,
        @NonNull String model,
        @NonNull @JsonProperty("questions") Map<String, Question> questionMap
) {

    /// Creates a request builder using `jev-latest` by default.
    ///
    /// @return a new builder
    public static SystemOneRequestBuilder builder() {
        return new SystemOneRequestBuilder();
    }

    /// Builds a [SystemOneRequest] with text state and named questions.
    public static class SystemOneRequestBuilder {

        private final Map<String, Question> questionMap = new HashMap<>();
        private String state;
        private String model = Model.JEV_LATEST.getModelAlias();

        /// Creates a builder using `jev-latest` with no state or questions.
        public SystemOneRequestBuilder() { }

        /// Sets the text to evaluate.
        ///
        /// @param state the input text
        /// @return this builder
        public SystemOneRequestBuilder withSimpleState(@NonNull String state) {
            this.state = state;
            return this;
        }

        /// Selects a known model.
        ///
        /// @param model the model to use
        /// @return this builder
        public SystemOneRequestBuilder withModel(@NonNull Model model) {
            this.model = model.getModelAlias();
            return this;
        }

        /// Selects a model by its API alias.
        ///
        /// @param model the model alias
        /// @return this builder
        public SystemOneRequestBuilder withModel(@NonNull String model) {
            this.model = model;
            return this;
        }

        /// Adds a question, replacing any question with the same identifier.
        ///
        /// @param questionId the identifier used to retrieve the answer
        /// @param question the question to evaluate
        /// @return this builder
        public SystemOneRequestBuilder withQuestion(@NonNull String questionId, @NonNull Question question) {
            this.questionMap.put(questionId, question);
            return this;
        }

        /// Creates a request with the configured state, model, and questions.
        ///
        /// @return the request
        public SystemOneRequest build() {
            return new SystemOneRequest(state, model, questionMap);
        }
    }
}
