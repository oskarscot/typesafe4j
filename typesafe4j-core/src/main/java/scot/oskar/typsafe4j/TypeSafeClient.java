package scot.oskar.typsafe4j;

import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.internal.TypeSafeClientBuilderImpl;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;
import scot.oskar.typsafe4j.systemone.SystemOneResponse;

public interface TypeSafeClient {

    static TypeSafeClientBuilder builder() {
        return new TypeSafeClientBuilderImpl();
    }

    @NonNull
    SystemOneResponse systemOne(@NonNull SystemOneRequest request);

}
