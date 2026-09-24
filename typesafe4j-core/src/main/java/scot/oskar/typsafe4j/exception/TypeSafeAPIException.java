package scot.oskar.typsafe4j.exception;

/// Indicates a failed TypeSafe API call or an unreadable response.
public class TypeSafeAPIException extends RuntimeException {

    /// Creates an exception describing the failure.
    ///
    /// @param message the failure description
    public TypeSafeAPIException(String message) {
        super(message);
    }

}
