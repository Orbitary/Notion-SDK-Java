package xyz.orbitary.notion.exception;

public class NotionRateLimitException extends NotionException {
    private final long retryAfterSeconds;

    public NotionRateLimitException(String message, long retryAfterSeconds) {
        super(429, "rate_limited", message);
        this.retryAfterSeconds = retryAfterSeconds;
    }

    public long getRetryAfterSeconds() {
        return retryAfterSeconds;
    }

}
