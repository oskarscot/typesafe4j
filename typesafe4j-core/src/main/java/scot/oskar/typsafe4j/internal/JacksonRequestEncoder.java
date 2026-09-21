package scot.oskar.typsafe4j.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import scot.oskar.typsafe4j.serialiser.RequestEncoder;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;
import scot.oskar.typsafe4j.transport.TransportRequest;

final class JacksonRequestEncoder implements RequestEncoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public TransportRequest buildRequest(SystemOneRequest request) {
        return null;
    }
}
