package scot.oskar.typsafe4j.credential;

public final class EnvironmentTypeSafeCredentialProvider implements TypeSafeCredentialProvider {

    @Override
    public String getAuthorizationToken() {
        return System.getenv("TYPESAFE_AUTH_TOKEN");
    }

}
