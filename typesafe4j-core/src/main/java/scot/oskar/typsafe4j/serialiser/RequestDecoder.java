package scot.oskar.typsafe4j.serialiser;

import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.systemone.SystemOneResponse;
import scot.oskar.typsafe4j.transport.TransportResponse;

/// Converts transport responses into System One responses.
public interface RequestDecoder {

    /// Decodes a response body into answers and token usage.
    ///
    /// @param response the response to decode
    /// @return the decoded response
    /// @throws scot.oskar.typsafe4j.exception.TypeSafeAPIException if the response cannot be parsed
    SystemOneResponse decode(@NonNull TransportResponse response);
}
