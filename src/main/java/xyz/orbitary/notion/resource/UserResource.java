package xyz.orbitary.notion.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import xyz.orbitary.notion.Notion;
import xyz.orbitary.notion.http.NotionHttpClient;
import xyz.orbitary.notion.model.common.PaginatedList;
import xyz.orbitary.notion.model.user.NotionUser;


/**
 * Resource for interacting with Notion users.
 */
public class UserResource {
    private final NotionHttpClient http = Notion.get().http();

    public NotionUser retrieve(String userId) {
        return http.get("/users/" + userId, NotionUser.class);
    }

    public NotionUser me() {
        return http.get("/users/me", NotionUser.class);
    }

    public PaginatedList<NotionUser> list() {
        return http.get("/users", new TypeReference<>() {
        });
    }

    public PaginatedList<NotionUser> list(String startCursor, int pageSize) {
        String url = "/users?page_size=" + pageSize;
        if (startCursor != null) url += "&start_cursor=" + startCursor;
        return http.get(url, new TypeReference<>() {
        });
    }

}
