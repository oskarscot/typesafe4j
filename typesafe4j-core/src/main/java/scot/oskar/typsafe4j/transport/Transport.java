package scot.oskar.typsafe4j.transport;

public interface Transport {

    TransportResponse execute(TransportRequest request);
}
