package xyz.orbitary.notion.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import xyz.orbitary.notion.Notion;
import xyz.orbitary.notion.http.NotionHttpClient;
import xyz.orbitary.notion.model.common.PaginatedList;
import xyz.orbitary.notion.model.view.NotionView;

import java.util.Map;


/**
 * Resource for interacting with Notion views.
 */
public class ViewResource {
    private final NotionHttpClient http = Notion.get().http();
    
    public PaginatedList<NotionView> list(String databaseId) {
        return http.get("/views?database_id=" + databaseId,
                new TypeReference<PaginatedList<NotionView>>() {
                });
    }

    public NotionView retrieve(String viewId) {
        return http.get("/views/" + viewId, NotionView.class);
    }

    public NotionView update(String viewId, Map<String, Object> body) {
        return http.patch("/views/" + viewId, body, NotionView.class);
    }

    public NotionView delete(String viewId) {
        return http.delete("/views/" + viewId, NotionView.class);
    }

}
