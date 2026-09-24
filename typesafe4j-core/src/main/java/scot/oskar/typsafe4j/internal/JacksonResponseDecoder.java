package scot.oskar.typsafe4j.internal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.exception.TypeSafeAPIException;
import scot.oskar.typsafe4j.serialiser.RequestDecoder;
import scot.oskar.typsafe4j.systemone.SystemOneResponse;
import scot.oskar.typsafe4j.transport.TransportResponse;

/// Decodes System One JSON responses using Jackson.
public class JacksonResponseDecoder implements RequestDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /// Creates a decoder with a default Jackson mapper.
    public JacksonResponseDecoder() { }

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
