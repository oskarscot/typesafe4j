package scot.oskar.typesafe4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import scot.oskar.typsafe4j.internal.JacksonRequestEncoder;
import scot.oskar.typsafe4j.model.Model;
import scot.oskar.typsafe4j.systemone.NoulCriteria;
import scot.oskar.typsafe4j.systemone.Question;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestEncoderTest {

    @Test
    public void testParsesRequest() throws JsonProcessingException {
        var objectMapper = new ObjectMapper();

        var request = SystemOneRequest.builder()
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
                .build();

        var transportRequest = new JacksonRequestEncoder().buildRequest(request);

        var systemOneRequest = objectMapper.readValue(transportRequest.body(), SystemOneRequest.class);

        assertEquals(request, systemOneRequest);

    }
}
