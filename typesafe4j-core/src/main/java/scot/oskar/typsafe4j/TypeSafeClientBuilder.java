package scot.oskar.typsafe4j;

import scot.oskar.typsafe4j.credential.TypeSafeCredentialProvider;

import java.time.Duration;

public interface TypeSafeClientBuilder {

    TypeSafeClientBuilder withCredentialProvider(TypeSafeCredentialProvider credentialProvider);

    TypeSafeClientBuilder withTimeout(Duration timeout);

    TypeSafeClient build();

}
