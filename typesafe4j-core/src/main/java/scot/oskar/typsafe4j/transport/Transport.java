package scot.oskar.typsafe4j.transport;

/// Sends encoded requests to the TypeSafe API.
public interface Transport {

    /// Sends a request and waits for its response.
    ///
    /// @param request the encoded request
    /// @return the raw response
    /// @throws scot.oskar.typsafe4j.exception.TypeSafeAPIException if the request cannot be completed
    TransportResponse execute(TransportRequest request);
}
