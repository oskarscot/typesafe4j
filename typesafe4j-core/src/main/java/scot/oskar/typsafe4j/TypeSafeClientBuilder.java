package scot.oskar.typsafe4j;

import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.credential.TypeSafeCredentialProvider;

import java.time.Duration;

public interface TypeSafeClientBuilder {

    @NonNull
    TypeSafeClientBuilder withCredentialProvider(@NonNull TypeSafeCredentialProvider credentialProvider);

    @NonNull
    TypeSafeClientBuilder withTimeout(@NonNull Duration timeout);

    @NonNull
    TypeSafeClient build();

}
