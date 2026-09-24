# TypeSafe4J

A Java client for the TypeSafe System One API. Send yes/no, choice, and scoring questions in one request and read typed answers with confidence scores and token usage.

## Requirements

- JDK 25, with `JAVA_HOME` pointing to your JDK.
- A TypeSafe API token for live requests.

## Build from source

The client lives in the `typesafe4j-core` module. Build its JAR from the repository root:

```sh
./gradlew :typesafe4j-core:assemble
```

The JAR is written to `typesafe4j-core/build/libs/`. It requires the runtime dependencies declared in [the module build file](typesafe4j-core/build.gradle.kts). Artifact publishing is not currently configured in this repository.

On Windows, use `gradlew.bat` in place of `./gradlew`.

## Quick start

Set your token in the environment before running your application:

```sh
export TYPESAFE_AUTH_TOKEN="your-api-token"
```

With `typesafe4j-core` and its dependencies on your application's classpath:

```java
import scot.oskar.typsafe4j.TypeSafeClient;
import scot.oskar.typsafe4j.credential.EnvironmentTypeSafeCredentialProvider;
import scot.oskar.typsafe4j.model.Model;
import scot.oskar.typsafe4j.question.ChoiceQuestion;
import scot.oskar.typsafe4j.question.NoulQuestion;
import scot.oskar.typsafe4j.question.ScoreQuestion;
import scot.oskar.typsafe4j.systemone.SystemOneRequest;

public class Example {
    void main(String[] args) {
        var client = TypeSafeClient.builder()
                .withCredentialProvider(new EnvironmentTypeSafeCredentialProvider())
                .build();

        var request = SystemOneRequest.builder()
                .withSimpleState("My order arrived damaged. Please refund it today.")
                .withModel(Model.JEV_LATEST)
                .withQuestion("refund", NoulQuestion.builder()
                        .instructions("Is the customer requesting a refund?")
                        .build())
                .withQuestion("department", ChoiceQuestion.builder()
                        .withInstructions("Which department should handle this request?")
                        .withCriteria("sales", "Questions about buying a product")
                        .withCriteria("support", "Problems with an existing order")
                        .build())
                .withQuestion("urgency", ScoreQuestion.builder()
                        .instructions("How urgent is this request?")
                        .criteria("Low: no deadline", "Medium: soon", "High: today")
                        .build())
                .build();

        var response = client.systemOne(request);

        System.out.println("Refund: " + response.noul("refund").isTrue());
        System.out.println("Department: " + response.choice("department").choice());
        System.out.println("Urgency: " + response.score("urgency").score());
        System.out.println("Token usage: " + response.usage());
    }
}
```

`systemOne` waits for the response. Retrieve each answer using the identifier supplied to `withQuestion`.

## Questions and answers

| Question | Answer | Details |
| --- | --- | --- |
| `NoulQuestion` | `NoulAnswer` | Yes/no confidence; `isTrue()` returns `true` when confidence exceeds `0.5`. |
| `ChoiceQuestion` | `ChoiceAnswer` | Selected choice, confidence, and probabilities for each choice. |
| `ScoreQuestion` | `ScoreAnswer` | Numeric score, confidence, legend, and probabilities. |

Use `NoulCriteria` to supply optional descriptions for true and false outcomes. The request builder accepts text state through `withSimpleState`; the `SystemOneRequest` constructor also accepts a JSON-serialisable object as state.

`response.answer(id)` returns the common `Answer` type. Typed lookups throw `IllegalArgumentException` for a missing answer and `IllegalStateException` for an unexpected answer type.

## Configuration

Supply a credential provider when building the client:

- `EnvironmentTypeSafeCredentialProvider` reads `TYPESAFE_AUTH_TOKEN`.
- `BasicTypeSafeCredentialProvider` accepts a token in its constructor.
- Implement `TypeSafeCredentialProvider` to load tokens from another source.

Tokens should omit the `Bearer ` prefix; the client adds it when sending requests.

The request builder defaults to `Model.JEV_LATEST`. Select `Model.JEV_PREVIEW` or pass an API model alias to `withModel(String)`.

`TypeSafeClientBuilder.withTimeout(Duration)` sets the connection timeout, which defaults to 30 seconds. Each HTTP request also has a fixed 30-second timeout.

Failed network calls and unreadable responses throw `TypeSafeAPIException`. Requests that cannot be serialised throw `IllegalArgumentException`.
