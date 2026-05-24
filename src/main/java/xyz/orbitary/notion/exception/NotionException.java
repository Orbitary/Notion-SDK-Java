package xyz.orbitary.notion.exception;

public class NotionException extends RuntimeException {
    private final int statusCode;
    private final String notionCode;

    public NotionException(int statusCode, String notionCode, String message) {
        super(message);
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
