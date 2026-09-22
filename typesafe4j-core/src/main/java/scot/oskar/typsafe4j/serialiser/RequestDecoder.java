package scot.oskar.typsafe4j.serialiser;

import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.systemone.SystemOneResponse;
import scot.oskar.typsafe4j.transport.TransportResponse;

public interface RequestDecoder {

    SystemOneResponse decode(@NonNull TransportResponse response);
}
