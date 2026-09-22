package scot.oskar.typsafe4j.credential;

import org.jspecify.annotations.NonNull;

public final class BasicTypeSafeCredentialProvider implements TypeSafeCredentialProvider {

    private final String apiKey;

    public BasicTypeSafeCredentialProvider(@NonNull String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public @NonNull String getAuthorizationToken() {
        return this.apiKey;
    }

}
