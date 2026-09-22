package scot.oskar.typsafe4j.credential;

import org.jspecify.annotations.NonNull;

public interface TypeSafeCredentialProvider {

    @NonNull
    String getAuthorizationToken();

}
