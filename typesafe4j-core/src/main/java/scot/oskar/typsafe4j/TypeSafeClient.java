package scot.oskar.typsafe4j;

import scot.oskar.typsafe4j.internal.TypeSafeClientBuilderImpl;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;
import scot.oskar.typsafe4j.systemone.SystemOneResponse;

public interface TypeSafeClient {

    static TypeSafeClientBuilder builder() {
        return new TypeSafeClientBuilderImpl();
    }

    SystemOneResponse systemOne(SystemOneRequest request);

}
