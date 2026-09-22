package scot.oskar.typsafe4j.serialiser;

import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;
import scot.oskar.typsafe4j.transport.TransportRequest;

public interface RequestEncoder {

    TransportRequest buildRequest(@NonNull SystemOneRequest systemOneRequest);
}
