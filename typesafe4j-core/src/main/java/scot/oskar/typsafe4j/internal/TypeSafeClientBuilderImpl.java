package scot.oskar.typsafe4j.internal;

import scot.oskar.typsafe4j.TypeSafeClient;
import scot.oskar.typsafe4j.TypeSafeClientBuilder;
import scot.oskar.typsafe4j.credential.TypeSafeCredentialProvider;

import java.time.Duration;

public final class TypeSafeClientBuilderImpl implements TypeSafeClientBuilder {

    private TypeSafeCredentialProvider credentialProvider;
    private Duration timeout =  Duration.ofSeconds(30);

    public TypeSafeClientBuilderImpl() { }

    @Override
    public TypeSafeClientBuilder withCredentialProvider(TypeSafeCredentialProvider credentialProvider) {
        this.credentialProvider = credentialProvider;
        return this;
    }

    public TypeSafeClientBuilder withTimeout(Duration timeout) {
        this.timeout = timeout;
        return this;
    }

    @Override
    public TypeSafeClient build() {
        return new TypeSafeClientImpl(this.credentialProvider, timeout);
    }
}
