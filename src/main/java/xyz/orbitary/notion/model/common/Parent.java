package xyz.orbitary.notion.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Parent {
    private String type;
    @JsonProperty("page_id")
    private String pageId;
    @JsonProperty("block_id")
    private String blockId;
    @JsonProperty("database_id")
    private String databaseId;
    @JsonProperty("data_source_id")
    private String dataSourceId;
    private Boolean workspace;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String v) {
        this.pageId = v;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String v) {
        this.blockId = v;
    }

    public String getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(String v) {
        this.databaseId = v;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(String v) {
        this.dataSourceId = v;
    }

    public Boolean getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Boolean v) {
        this.workspace = v;
    }

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
