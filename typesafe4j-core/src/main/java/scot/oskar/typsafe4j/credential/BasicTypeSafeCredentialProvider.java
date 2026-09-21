package scot.oskar.typsafe4j.credential;

public class BasicTypeSafeCredentialProvider implements TypeSafeCredentialProvider {

    private final String apiKey;

    public BasicTypeSafeCredentialProvider(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String getAuthorizationToken() {
        return this.apiKey;
    }

}
