package scot.oskar.typsafe4j;

import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.internal.TypeSafeClientBuilderImpl;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;
import scot.oskar.typsafe4j.systemone.SystemOneResponse;

/// Client for sending questions to the TypeSafe System One API.
public interface TypeSafeClient {

    /// Creates a client builder.
    ///
    /// @return a new builder
    static TypeSafeClientBuilder builder() {
        return new TypeSafeClientBuilderImpl();
    }

    /// Sends a System One request and waits for its answers.
    ///
    /// @param request the state, model, and questions to send
    /// @return the answers and token usage
    /// @throws IllegalArgumentException if the request cannot be serialised
    /// @throws scot.oskar.typsafe4j.exception.TypeSafeAPIException if the call fails or the response cannot be parsed
    @NonNull
    SystemOneResponse systemOne(@NonNull SystemOneRequest request);

}
