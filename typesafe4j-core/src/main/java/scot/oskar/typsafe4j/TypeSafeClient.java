package scot.oskar.typsafe4j;

import scot.oskar.typsafe4j.internal.TypeSafeClientBuilderImpl;

public interface TypeSafeClient {

    static TypeSafeClientBuilder builder() {
        return new TypeSafeClientBuilderImpl();
    }

    SystemOneClient systemOne();

}
