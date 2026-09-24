package scot.oskar.typsafe4j;

import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.credential.TypeSafeCredentialProvider;

import java.time.Duration;

/// Configures and creates a [TypeSafeClient].
public interface TypeSafeClientBuilder {

    /// Sets the provider used to authenticate requests.
    ///
    /// @param credentialProvider the token provider
    /// @return this builder
    @NonNull
    TypeSafeClientBuilder withCredentialProvider(@NonNull TypeSafeCredentialProvider credentialProvider);

    /// Sets the connection timeout, which defaults to 30 seconds.
    ///
    /// @param timeout a positive connection timeout
    /// @return this builder
    @NonNull
    TypeSafeClientBuilder withTimeout(@NonNull Duration timeout);

    /// Creates a client with the configured credentials and timeout.
    ///
    /// @return a new client
    /// @throws IllegalArgumentException if the timeout is not positive
    @NonNull
    TypeSafeClient build();

}
