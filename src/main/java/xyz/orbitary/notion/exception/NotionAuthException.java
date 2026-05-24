package xyz.orbitary.notion.exception;

public class NotionAuthException extends NotionException {
    public NotionAuthException(int statusCode, String notionCode, String message) {
        super(statusCode, notionCode, message);
    }

}
