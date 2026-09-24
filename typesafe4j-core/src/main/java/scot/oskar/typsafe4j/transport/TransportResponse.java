package scot.oskar.typsafe4j.transport;

import java.util.List;
import java.util.Map;

/// A raw HTTP response from the API.
///
/// @param statusCode the HTTP status code
/// @param headers response header names and their values
/// @param body the response body
public record TransportResponse(
        int statusCode,
        Map<String, List<String>> headers,
        String body
) { }
