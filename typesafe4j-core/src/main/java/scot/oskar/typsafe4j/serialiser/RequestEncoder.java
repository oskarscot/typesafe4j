package scot.oskar.typsafe4j.serialiser;

import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;
import scot.oskar.typsafe4j.transport.TransportRequest;

/// Converts System One requests into transport requests.
public interface RequestEncoder {

    /// Encodes a System One request for transport.
    ///
    /// @param systemOneRequest the request to encode
    /// @return the encoded request
    /// @throws IllegalArgumentException if the request cannot be serialised
    TransportRequest buildRequest(@NonNull SystemOneRequest systemOneRequest);
}
