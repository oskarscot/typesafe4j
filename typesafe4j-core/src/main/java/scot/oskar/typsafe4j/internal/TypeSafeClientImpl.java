package scot.oskar.typsafe4j.internal;

import scot.oskar.typsafe4j.credential.TypeSafeCredentialProvider;
import scot.oskar.typsafe4j.TypeSafeClient;
import scot.oskar.typsafe4j.transport.Transport;

import java.time.Duration;

public class TypeSafeClientImpl implements TypeSafeClient {

    private final Transport transport;
    private final TypeSafeCredentialProvider credentialProvider;

    TypeSafeClientImpl(TypeSafeCredentialProvider credentialProvider, Duration readTimeout) {
        this.credentialProvider = credentialProvider;
        this.transport = new DefaultHttpTransportImpl(credentialProvider, readTimeout);
    }

    @Override
    public SystemOneClient systemOne() {
        return null;
    }
}
