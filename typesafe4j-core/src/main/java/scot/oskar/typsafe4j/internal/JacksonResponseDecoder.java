package scot.oskar.typsafe4j.internal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.exception.TypeSafeAPIException;
import scot.oskar.typsafe4j.serialiser.RequestDecoder;
import scot.oskar.typsafe4j.systemone.SystemOneResponse;
import scot.oskar.typsafe4j.transport.TransportResponse;

public class JacksonResponseDecoder implements RequestDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public SystemOneResponse decode(@NonNull TransportResponse response) {
        try {
            return objectMapper.readValue(response.body(), SystemOneResponse.class);
        } catch (JsonProcessingException e) {
            IO.println(e.getMessage());
            throw new TypeSafeAPIException("Response could not be parsed.");
        }
    }
}
