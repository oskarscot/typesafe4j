package scot.oskar.typsafe4j.credential;

import org.jspecify.annotations.NonNull;

/// Reads the TypeSafe API token from the `TYPESAFE_AUTH_TOKEN` environment variable.
public final class EnvironmentTypeSafeCredentialProvider implements TypeSafeCredentialProvider {

    /// Creates a provider that reads `TYPESAFE_AUTH_TOKEN`.
    public EnvironmentTypeSafeCredentialProvider() { }

    /// Reads the token from the environment.
    ///
    /// @return the value of `TYPESAFE_AUTH_TOKEN`, or `null` if it is unset
    @Override
    public @NonNull String getAuthorizationToken() {
        return System.getenv("TYPESAFE_AUTH_TOKEN");
    }

}
