package scot.oskar.typsafe4j.internal;

import org.jspecify.annotations.NonNull;
import scot.oskar.typsafe4j.transport.Transport;
import scot.oskar.typsafe4j.credential.TypeSafeCredentialProvider;
import scot.oskar.typsafe4j.exception.TypeSafeAPIException;
import scot.oskar.typsafe4j.transport.TransportRequest;
import scot.oskar.typsafe4j.transport.TransportResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.time.Duration;

final class DefaultHttpTransportImpl implements Transport, AutoCloseable {

    public static final String TYPESAFE_API_URL = "https://api.typesafe.ai/v1/";

    private static final int MAX_RESPONSE_BYTES = 1024 * 1024;

    private final HttpClient httpClient;
    private final TypeSafeCredentialProvider credentialProvider;

    public DefaultHttpTransportImpl(
            @NonNull TypeSafeCredentialProvider credentialProvider,
            @NonNull Duration connectTimeout) {
        this.credentialProvider = credentialProvider;
        this.httpClient = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NEVER)
                .connectTimeout(connectTimeout)
                .build();
    }

    @Override
    public TransportResponse execute(@NonNull TransportRequest request) {
        var builder = HttpRequest.newBuilder()
                .uri(URI.create(TYPESAFE_API_URL + request.endpointUri()))
                .timeout(Duration.ofSeconds(30))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + credentialProvider.getAuthorizationToken())
                .POST(HttpRequest.BodyPublishers.ofString(request.body()));

        request.headers().forEach(builder::header);

        try {
            var response = httpClient.send(builder.build(), HttpResponse.BodyHandlers.limiting(HttpResponse.BodyHandlers.ofString(Charset.defaultCharset()), MAX_RESPONSE_BYTES));
            return new TransportResponse(response.statusCode(), response.headers().map(), response.body());
        } catch (IOException e) {
            throw new TypeSafeAPIException("TypeSafe API unavailable");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new TypeSafeAPIException("TypeSafe API request interrupted");
        }
    }

    @Override
    public void close() {
        httpClient.shutdown();
    }
}
