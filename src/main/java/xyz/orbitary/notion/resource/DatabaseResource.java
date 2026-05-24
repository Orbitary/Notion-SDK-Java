package xyz.orbitary.notion.resource;

import xyz.orbitary.notion.Notion;
import xyz.orbitary.notion.http.NotionHttpClient;
import xyz.orbitary.notion.model.database.NotionDatabase;
import xyz.orbitary.notion.query.DatabaseQuery;


/**
 * Resource for interacting with Notion databases.
 */
public class DatabaseResource {
    private final NotionHttpClient http = Notion.get().http();

    public NotionDatabase retrieve(String databaseId) {
        return http.get("/databases/" + databaseId, NotionDatabase.class);
    }

    public DatabaseQuery query(String databaseId) {
        return new DatabaseQuery(databaseId);
    }

}
