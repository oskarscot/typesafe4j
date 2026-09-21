package scot.oskar.typesafe4j;

import org.junit.jupiter.api.Test;
import scot.oskar.typsafe4j.TypeSafeClient;
import scot.oskar.typsafe4j.credential.BasicTypeSafeCredentialProvider;
import scot.oskar.typsafe4j.credential.EnvironmentTypeSafeCredentialProvider;
import scot.oskar.typsafe4j.model.Model;
import scot.oskar.typsafe4j.systemone.NoulCriteria;
import scot.oskar.typsafe4j.systemone.Question;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;
import scot.oskar.typsafe4j.systemone.SystemOneResponse;

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
                        new Question.NoulQuestion(
                                "is this person angry?",
                                new NoulCriteria(
                                        "yes this person is very mad",
                                        "nah they chill like that"
                                )
                        )

                )
                .withQuestion(
                        "is_refund",
                        Question.NoulQuestion.basic("is this question about a refund?")
                )
                .build());
    }
}
