package scot.oskar.typsafe4j.transport;

import java.util.List;
import java.util.Map;

public record TransportResponse(
        int statusCode,
        Map<String, List<String>> headers,
        String body
) { }
