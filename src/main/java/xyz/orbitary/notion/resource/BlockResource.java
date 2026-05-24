package xyz.orbitary.notion.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import xyz.orbitary.notion.Notion;
import xyz.orbitary.notion.http.NotionHttpClient;
import xyz.orbitary.notion.model.block.NotionBlock;
import xyz.orbitary.notion.model.common.PaginatedList;

import java.util.Map;


public class BlockResource {
    private final NotionHttpClient http = Notion.get().http();

    public PaginatedList<NotionBlock> children(String blockId) {
        return http.get("/blocks/" + blockId + "/children",
                new TypeReference<PaginatedList<NotionBlock>>() {
                });
    }

    public PaginatedList<NotionBlock> children(String blockId, String startCursor, int pageSize) {
        String url = "/blocks/" + blockId + "/children?page_size=" + pageSize;
        if (startCursor != null) url += "&start_cursor=" + startCursor;
        return http.get(url, new TypeReference<PaginatedList<NotionBlock>>() {
        });
    }

    public NotionBlock update(String blockId, Map<String, Object> body) {
        return http.patch("/blocks/" + blockId, body, NotionBlock.class);
    }

    public NotionBlock delete(String blockId) {
        return http.delete("/blocks/" + blockId, NotionBlock.class);
    }

}
