package scot.oskar.typsafe4j.serialiser;

import scot.oskar.typsafe4j.systemone.SystemOneRequest;
import scot.oskar.typsafe4j.transport.TransportRequest;

public interface RequestEncoder {

    TransportRequest buildRequest(SystemOneRequest systemOneRequest);
}
