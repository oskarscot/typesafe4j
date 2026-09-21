package scot.oskar.typsafe4j.transport;

import java.net.URI;
import java.util.Map;

public record TransportRequest(
        URI endpointUri,
        Map<String, String> headers,
        String body
) { }
