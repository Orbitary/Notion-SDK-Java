package xyz.orbitary.notion.resource;

import xyz.orbitary.notion.Notion;
import xyz.orbitary.notion.http.NotionHttpClient;
import xyz.orbitary.notion.model.page.NotionPage;

import java.util.Map;


/**
 * Resource for interacting with Notion pages.
 */
public class PageResource {
    private final NotionHttpClient http = Notion.get().http();

    public NotionPage retrieve(String pageId) {
        return http.get("/pages/" + pageId, NotionPage.class);
    }

    public NotionPage create(Map<String, Object> body) {
        return http.post("/pages", body, NotionPage.class);
    }

    public NotionPage update(String pageId, Map<String, Object> properties) {
        return http.patch("/pages/" + pageId, Map.of("properties", properties), NotionPage.class);
    }

    public NotionPage trash(String pageId) {
        return http.delete("/pages/" + pageId, NotionPage.class);
    }

}
