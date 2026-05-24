package xyz.orbitary.notion.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.user.NotionUser;

import java.time.OffsetDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class NotionObject {
    private String id;
    @JsonProperty("created_time")
    private OffsetDateTime createdTime;
    @JsonProperty("created_by")
    private NotionUser createdBy;
    @JsonProperty("last_edited_time")
    private OffsetDateTime lastEditedTime;
    @JsonProperty("last_edited_by")
    private NotionUser lastEditedBy;
    @JsonProperty("in_trash")
    private boolean inTrash;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OffsetDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(OffsetDateTime v) {
        this.createdTime = v;
    }

    public NotionUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(NotionUser v) {
        this.createdBy = v;
    }

    public OffsetDateTime getLastEditedTime() {
        return lastEditedTime;
    }

    public void setLastEditedTime(OffsetDateTime v) {
        this.lastEditedTime = v;
    }

    public NotionUser getLastEditedBy() {
        return lastEditedBy;
    }

    public void setLastEditedBy(NotionUser v) {
        this.lastEditedBy = v;
    }

    public boolean isInTrash() {
        return inTrash;
    }

    public void setInTrash(boolean v) {
        this.inTrash = v;
    }

}
