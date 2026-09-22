package scot.oskar.typsafe4j.internal;

import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.TypeSafeClient;
import scot.oskar.typsafe4j.TypeSafeClientBuilder;
import scot.oskar.typsafe4j.credential.TypeSafeCredentialProvider;

import java.time.Duration;

public final class TypeSafeClientBuilderImpl implements TypeSafeClientBuilder {

    private TypeSafeCredentialProvider credentialProvider;
    private Duration timeout =  Duration.ofSeconds(30);

    public TypeSafeClientBuilderImpl() { }

    @Override
    public @NonNull TypeSafeClientBuilder withCredentialProvider(@NonNull TypeSafeCredentialProvider credentialProvider) {
        this.credentialProvider = credentialProvider;
        return this;
    }

    public @NonNull TypeSafeClientBuilder withTimeout(@NonNull Duration timeout) {
        this.timeout = timeout;
        return this;
    }

    @Override
    public @NonNull TypeSafeClient build() {
        return new TypeSafeClientImpl(this.credentialProvider, timeout);
    }
}
