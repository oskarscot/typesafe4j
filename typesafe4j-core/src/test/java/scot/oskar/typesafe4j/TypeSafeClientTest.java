package scot.oskar.typesafe4j;

import org.junit.jupiter.api.Test;
import scot.oskar.typsafe4j.TypeSafeClient;
import scot.oskar.typsafe4j.credential.EnvironmentTypeSafeCredentialProvider;
import scot.oskar.typsafe4j.model.Model;
import scot.oskar.typsafe4j.question.*;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TypeSafeClientTest {

    @Test
    public void testTypeSafeClient() {
        var client = TypeSafeClient.builder()
                .withCredentialProvider(new EnvironmentTypeSafeCredentialProvider())
                .build();

        var systemOneResponse = client.systemOne(SystemOneRequest.builder()
                .withSimpleState("hello i want my refund now or i will be giga angry")
                .withModel(Model.JEV_LATEST)
                .withQuestion(
                        "is_angry",
                        NoulQuestion.builder()
                                .instructions("is this person angry?")
                                .criteria(new NoulCriteria(
                                        "yes this person is very mad",
                                        "nah they chill like that"
                                ))
                                .build()
                )
                .withQuestion(
                        "is_refund",
                        NoulQuestion.builder()
                                .instructions("is this question about a refund?")
                                .build()
                )
                .withQuestion(
                        "calmness_level",
                        ChoiceQuestion.builder()
                                .withInstructions("how calm is this person?")
                                .withCriteria("very_calm", "customer is very calm")
                                .withCriteria("moderate", "the customer is a bit frustrated")
                                .withCriteria("angry", "this customer is not calm at all")
                                .build()
                )
                .withQuestion("department_score",
                        ScoreQuestion.builder()
                                .instructions("which department should deal with this?")
                                .criteria("sales", "customer_support", "development")
                                .build()
                )
                .build());

        var isRefund = systemOneResponse.noul("is_refund").isTrue();

        assertTrue(isRefund, "Response expected to be about a refund");
    }
}
