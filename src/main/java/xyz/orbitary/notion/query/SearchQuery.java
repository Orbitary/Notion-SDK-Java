package xyz.orbitary.notion.query;

import com.fasterxml.jackson.core.type.TypeReference;
import org.jetbrains.annotations.Nullable;
import xyz.orbitary.notion.Notion;
import xyz.orbitary.notion.http.NotionHttpClient;
import xyz.orbitary.notion.model.common.PaginatedList;
import xyz.orbitary.notion.model.page.NotionPage;

import java.util.HashMap;
import java.util.Map;


public class SearchQuery {
    private final NotionHttpClient http = Notion.get().http();
    private @Nullable String query;
    private @Nullable String filterType;
    private @Nullable String sortDirection;
    private @Nullable Integer pageSize;
    private @Nullable String startCursor;

    public SearchQuery query(String query) {
        this.query = query;
        return this;
    }

    public SearchQuery filterPages() {
        this.filterType = "page";
        return this;
    }

    public SearchQuery filterDatabases() {
        this.filterType = "database";
        return this;
    }

    public SearchQuery sortDescending() {
        this.sortDirection = "descending";
        return this;
    }

    public SearchQuery sortAscending() {
        this.sortDirection = "ascending";
        return this;
    }

    public SearchQuery pageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public SearchQuery startCursor(String cursor) {
        this.startCursor = cursor;
        return this;
    }

    public PaginatedList<NotionPage> execute() {
        Map<String, Object> body = new HashMap<>();
        if (query != null) body.put("query", query);
        if (filterType != null) {
            Map<String, Object> filter = new HashMap<>();
            filter.put("value", filterType);
            filter.put("property", "object");
            body.put("filter", filter);
        }
        if (sortDirection != null) {
            Map<String, Object> sort = new HashMap<>();
            sort.put("value", sortDirection);
            sort.put("timestamp", "last_edited_time");
            body.put("sort", sort);
        }
        if (pageSize != null) body.put("page_size", pageSize);
        if (startCursor != null) body.put("start_cursor", startCursor);
        return http.post("/search", body, new TypeReference<PaginatedList<NotionPage>>() {
        });
    }

}
