package scot.oskar.typsafe4j.transport;

import java.util.Map;

/// An encoded request ready to send to the API.
///
/// @param endpointUri the endpoint path relative to the API base URL
/// @param headers additional HTTP request headers
/// @param body the serialised request body
public record TransportRequest(
        String endpointUri,
        Map<String, String> headers,
        String body
) { }
