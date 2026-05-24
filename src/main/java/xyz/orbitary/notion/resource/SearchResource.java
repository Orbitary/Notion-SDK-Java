package xyz.orbitary.notion.resource;

import xyz.orbitary.notion.Notion;
import xyz.orbitary.notion.http.NotionHttpClient;
import xyz.orbitary.notion.query.SearchQuery;


/**
 * Resource for performing Notion searches.
 */
public class SearchResource {
    private final NotionHttpClient http = Notion.get().http();

    public SearchQuery query(String searchTerm) {
        return new SearchQuery().query(searchTerm);
    }

    public SearchQuery query() {
        return new SearchQuery();
    }

}
