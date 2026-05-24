package xyz.orbitary.notion.http;

import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.*;
import xyz.orbitary.notion.exception.NotionAuthException;
import xyz.orbitary.notion.exception.NotionException;
import xyz.orbitary.notion.exception.NotionNotFoundException;
import xyz.orbitary.notion.exception.NotionRateLimitException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static xyz.bitsquidd.bits.util.serializer.SerializationManager.SERIALIZER;


public class NotionHttpClient {
    private static final String BASE_URL = "https://api.notion.com/v1";
    private static final String NOTION_VERSION = "2022-06-28";
    private static final MediaType JSON_TYPE = MediaType.get("application/json; charset=utf-8");

    private final OkHttpClient client;

    public NotionHttpClient(String token) {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(chain -> chain.proceed(
                        chain.request().newBuilder()
                                .header("Authorization", "Bearer " + token)
                                .header("Notion-Version", NOTION_VERSION)
                                .header("Content-Type", "application/json")
                                .build()
                ))
                .build();
    }

    public <T> T get(String path, Class<T> type) {
        Request request = new Request.Builder().url(BASE_URL + path).get().build();
        return execute(request, body -> SERIALIZER.readValue(body, type));
    }

    public <T> T get(String path, TypeReference<T> type) {
        Request request = new Request.Builder().url(BASE_URL + path).get().build();
        return execute(request, body -> SERIALIZER.readValue(body, type));
    }

    public <T> T post(String path, Object requestBody, Class<T> type) {
        return execute(buildPost(path, requestBody), body -> SERIALIZER.readValue(body, type));
    }

    public <T> T post(String path, Object requestBody, TypeReference<T> type) {
        return execute(buildPost(path, requestBody), body -> SERIALIZER.readValue(body, type));
    }

    public <T> T patch(String path, Object requestBody, Class<T> type) {
        return execute(buildPatch(path, requestBody), body -> SERIALIZER.readValue(body, type));
    }

    public <T> T delete(String path, Class<T> type) {
        Request request = new Request.Builder().url(BASE_URL + path).delete().build();
        return execute(request, body -> SERIALIZER.readValue(body, type));
    }

    private Request buildPost(String path, Object requestBody) {
        try {
            return new Request.Builder()
                    .url(BASE_URL + path)
                    .post(RequestBody.create(SERIALIZER.writeValueAsString(requestBody), JSON_TYPE))
                    .build();
        } catch (IOException e) {
            throw new NotionException(0, "serialization_error", e.getMessage());
        }
    }

    private Request buildPatch(String path, Object requestBody) {
        try {
            return new Request.Builder()
                    .url(BASE_URL + path)
                    .patch(RequestBody.create(SERIALIZER.writeValueAsString(requestBody), JSON_TYPE))
                    .build();
        } catch (IOException e) {
            throw new NotionException(0, "serialization_error", e.getMessage());
        }
    }

    @FunctionalInterface
    private interface BodyParser<T> {
        T parse(String body) throws IOException;

    }

    private <T> T execute(Request request, BodyParser<T> parser) {
        try (Response response = client.newCall(request).execute()) {
            String body = response.body() != null ? response.body().string() : "{}";
            int code = response.code();
            if (code >= 200 && code < 300) {
                return parser.parse(body);
            }
            String notionCode = extractField(body, "code");
            String message = extractField(body, "message");
            switch (code) {
                case 401, 403 -> throw new NotionAuthException(code, notionCode, message);
                case 404 -> throw new NotionNotFoundException(notionCode, message);
                case 429 -> {
                    String retryAfter = response.header("Retry-After", "60");
                    long seconds = Long.parseLong(retryAfter != null ? retryAfter : "60");
                    throw new NotionRateLimitException(message, seconds);
                }
                default -> throw new NotionException(code, notionCode, message);
            }
        } catch (IOException e) {
            throw new NotionException(0, "io_error", "Request failed: " + e.getMessage());
        }
    }

    private String extractField(String body, String field) {
        try {
            return SERIALIZER.readTree(body).path(field).asText("unknown");
        } catch (IOException e) {
            return "unknown";
        }
    }

}
