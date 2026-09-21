package scot.oskar.typesafe4j;

import org.junit.jupiter.api.Test;
import scot.oskar.typsafe4j.TypeSafeClient;
import scot.oskar.typsafe4j.credential.BasicTypeSafeCredentialProvider;

public class TypeSafeClientTest {

    @Test
    public void testTypeSafeClient() {
        var client = TypeSafeClient.builder()
                .withCredentialProvider(new BasicTypeSafeCredentialProvider(""))
                .build();
    }
}
