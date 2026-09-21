package scot.oskar.typsafe4j.transport;

import java.net.http.HttpResponse;

public interface Transport {

    HttpResponse<?> execute(TransportRequest request);
}
