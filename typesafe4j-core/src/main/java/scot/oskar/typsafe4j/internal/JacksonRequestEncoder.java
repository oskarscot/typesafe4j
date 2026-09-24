package scot.oskar.typsafe4j.internal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.serialiser.RequestEncoder;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;
import scot.oskar.typsafe4j.transport.TransportRequest;

import java.util.Map;

/// Encodes System One requests as JSON using Jackson.
public final class JacksonRequestEncoder implements RequestEncoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public TransportRequest buildRequest(@NonNull SystemOneRequest request) {
        try {
            var json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
            return new TransportRequest("/systemone", Map.of(), json);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Failed to serialise body for " + request);
        }
    }
}
