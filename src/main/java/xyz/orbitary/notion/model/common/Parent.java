package xyz.orbitary.notion.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Parent(
        @JsonProperty("type") String type,
        @JsonProperty("page_id") String pageId,
        @JsonProperty("block_id") String blockId,
        @JsonProperty("database_id") String databaseId,
        @JsonProperty("data_source_id") String dataSourceId,
        @JsonProperty("workspace") Boolean workspace
) {
    public boolean isPage() {
        return "page_id".equals(type);
    }

    public boolean isBlock() {
        return "block_id".equals(type);
    }

    public boolean isDatabase() {
        return "database_id".equals(type);
    }

    public boolean isWorkspace() {
        return "workspace".equals(type);
    }

}
