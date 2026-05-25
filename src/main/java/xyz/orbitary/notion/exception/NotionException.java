package xyz.orbitary.notion.exception;

import org.jetbrains.annotations.Nullable;


public class NotionException extends RuntimeException {
    private final int statusCode;
    private final String notionCode;

    public NotionException(int statusCode, String notionCode, @Nullable String message) {
        super(message != null ? message : "Notion API error: " + notionCode + " (HTTP " + statusCode + ")");
        this.statusCode = statusCode;
        this.notionCode = notionCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getNotionCode() {
        return notionCode;
    }

}
