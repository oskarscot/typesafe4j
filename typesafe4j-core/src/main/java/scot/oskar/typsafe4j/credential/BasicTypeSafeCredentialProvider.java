package scot.oskar.typsafe4j.credential;

import org.jspecify.annotations.NonNull;

/// Supplies a fixed TypeSafe API token.
public final class BasicTypeSafeCredentialProvider implements TypeSafeCredentialProvider {

    private final String apiKey;

    /// Creates a provider for the given token.
    ///
    /// @param apiKey the token without the `Bearer ` prefix
    public BasicTypeSafeCredentialProvider(@NonNull String apiKey) {
        this.apiKey = apiKey;
    }

    /// Returns the token supplied to the constructor.
    ///
    /// @return the configured token
    @Override
    public @NonNull String getAuthorizationToken() {
        return this.apiKey;
    }

}
