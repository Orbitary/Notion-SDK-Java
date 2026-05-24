package xyz.orbitary.notion.query;

import com.fasterxml.jackson.core.type.TypeReference;
import xyz.orbitary.notion.Notion;
import xyz.orbitary.notion.http.NotionHttpClient;
import xyz.orbitary.notion.model.common.PaginatedList;
import xyz.orbitary.notion.model.page.NotionPage;

import java.util.*;
import java.util.stream.Collectors;


public class DatabaseQuery {
    private final NotionHttpClient http = Notion.get().http();
    private final String databaseId;
    private Filter filter;
    private final List<Sort> sorts = new ArrayList<>();
    private Integer pageSize;
    private String startCursor;

    public DatabaseQuery(String databaseId) {
        this.databaseId = databaseId;
    }

    public DatabaseQuery filter(Filter filter) {
        this.filter = filter;
        return this;
    }

    public DatabaseQuery sort(Sort... sorts) {
        this.sorts.addAll(Arrays.asList(sorts));
        return this;
    }

    public DatabaseQuery pageSize(int size) {
        this.pageSize = size;
        return this;
    }

    public DatabaseQuery startCursor(String c) {
        this.startCursor = c;
        return this;
    }

    public PaginatedList<NotionPage> execute() {
        Map<String, Object> body = new HashMap<>();
        if (filter != null) body.put("filter", filter.toJson());
        if (!sorts.isEmpty()) body.put("sorts", sorts.stream().map(Sort::toJson).collect(Collectors.toList()));
        if (pageSize != null) body.put("page_size", pageSize);
        if (startCursor != null) body.put("start_cursor", startCursor);
        return http.post("/databases/" + databaseId + "/query", body,
                new TypeReference<PaginatedList<NotionPage>>() {
                });
    }

    public List<NotionPage> executeAll() {
        List<NotionPage> all = new ArrayList<>();
        boolean hasMore = true;
        while (hasMore) {
            PaginatedList<NotionPage> page = execute();
            all.addAll(page.getResults());
            hasMore = page.isHasMore();
            this.startCursor = page.getNextCursor();
        }
        return all;
    }

}
