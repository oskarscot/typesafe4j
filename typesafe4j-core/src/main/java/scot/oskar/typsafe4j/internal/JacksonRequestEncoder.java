package scot.oskar.typsafe4j.internal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import scot.oskar.typsafe4j.serialiser.RequestEncoder;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;
import scot.oskar.typsafe4j.transport.TransportRequest;

import java.net.URI;
import java.util.Map;

public final class JacksonRequestEncoder implements RequestEncoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public TransportRequest buildRequest(SystemOneRequest request) {
        try {
            var json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
            IO.println(json);
            return new TransportRequest(URI.create("/systemone"), Map.of(), json);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Failed to serialise body for " + request);
        }
    }
}
