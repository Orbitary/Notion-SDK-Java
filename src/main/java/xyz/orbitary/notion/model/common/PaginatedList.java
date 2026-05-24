package xyz.orbitary.notion.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PaginatedList<T> {
    private List<T> results;
    @JsonProperty("next_cursor")
    private String nextCursor;
    @JsonProperty("has_more")
    private boolean hasMore;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(String v) {
        this.nextCursor = v;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean v) {
        this.hasMore = v;
    }

}
