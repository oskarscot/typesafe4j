package scot.oskar.typsafe4j.credential;

import org.jspecify.annotations.NonNull;

/// Supplies an authentication token for TypeSafe API requests.
public interface TypeSafeCredentialProvider {

    /// Returns the token to use for authentication.
    ///
    /// @return the token without the `Bearer ` prefix
    @NonNull
    String getAuthorizationToken();

}
