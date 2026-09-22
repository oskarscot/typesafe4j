package scot.oskar.typsafe4j.credential;

import org.jspecify.annotations.NonNull;

public final class EnvironmentTypeSafeCredentialProvider implements TypeSafeCredentialProvider {

    @Override
    public @NonNull String getAuthorizationToken() {
        return System.getenv("TYPESAFE_AUTH_TOKEN");
    }

}
