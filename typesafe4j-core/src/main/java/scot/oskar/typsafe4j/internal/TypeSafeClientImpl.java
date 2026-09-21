package scot.oskar.typsafe4j.internal;

import scot.oskar.typsafe4j.credential.TypeSafeCredentialProvider;
import scot.oskar.typsafe4j.TypeSafeClient;
import scot.oskar.typsafe4j.serialiser.RequestEncoder;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;
import scot.oskar.typsafe4j.systemone.SystemOneResponse;
import scot.oskar.typsafe4j.transport.Transport;

import java.time.Duration;

final class TypeSafeClientImpl implements TypeSafeClient {

    private final Transport transport;
    private final RequestEncoder requestEncoder;

    TypeSafeClientImpl(TypeSafeCredentialProvider credentialProvider, Duration readTimeout) {
        this.transport = new DefaultHttpTransportImpl(credentialProvider, readTimeout);
        this.requestEncoder = new JacksonRequestEncoder();
    }

    @Override
    public SystemOneResponse systemOne(SystemOneRequest request) {
        var response = requestEncoder.buildRequest(request);
        var execute = this.transport.execute(response);
        return null;
    }
}
