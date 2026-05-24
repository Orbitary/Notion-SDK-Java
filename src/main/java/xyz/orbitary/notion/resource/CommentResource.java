package xyz.orbitary.notion.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import xyz.orbitary.notion.Notion;
import xyz.orbitary.notion.http.NotionHttpClient;
import xyz.orbitary.notion.model.comment.NotionComment;
import xyz.orbitary.notion.model.common.PaginatedList;

import java.util.Map;


/**
 * Resource for interacting with Notion comments.
 */
public class CommentResource {
    private final NotionHttpClient http = Notion.get().http();

    public PaginatedList<NotionComment> list(String blockId) {
        return http.get("/comments?block_id=" + blockId,
                new TypeReference<PaginatedList<NotionComment>>() {
                });
    }

    public NotionComment create(Map<String, Object> body) {
        return http.post("/comments", body, NotionComment.class);
    }

}
