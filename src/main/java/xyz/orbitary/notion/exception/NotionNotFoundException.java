package xyz.orbitary.notion.exception;

public class NotionNotFoundException extends NotionException {
    public NotionNotFoundException(String notionCode, String message) {
        super(404, notionCode, message);
    }

}
