package scot.oskar.typesafe4j;

import org.junit.jupiter.api.Test;
import scot.oskar.typsafe4j.TypeSafeClient;
import scot.oskar.typsafe4j.credential.BasicTypeSafeCredentialProvider;
import scot.oskar.typsafe4j.credential.EnvironmentTypeSafeCredentialProvider;
import scot.oskar.typsafe4j.model.Model;
import scot.oskar.typsafe4j.question.*;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;

import java.util.List;
import java.util.Map;

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
                        new NoulQuestion(
                                "is this person angry?",
                                new NoulCriteria(
                                        "yes this person is very mad",
                                        "nah they chill like that"
                                )
                        )

                )
                .withQuestion(
                        "is_refund",
                        NoulQuestion.basic("is this question about a refund?")
                )
                .withQuestion(
                        "calmness_level",
                        new ChoiceQuestion("how calm is this person?", Map.of(
                                "very_calm", "customer is very calm",
                                "moderate", "the customer is a bit frustrated",
                                "angry", "this customer is not calm at all"
                            )
                        )
                )
                .withQuestion("calmness_score",
                        new ScoreQuestion(
                                "which department should deal with this?",
                                List.of("sales", "customer_support", "development")
                        )
                )
                .build());
    }
}
