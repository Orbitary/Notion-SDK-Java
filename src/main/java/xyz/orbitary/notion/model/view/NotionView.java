package xyz.orbitary.notion.model.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.common.NotionObject;
import xyz.orbitary.notion.model.common.Parent;
import xyz.orbitary.notion.model.user.NotionUser;

import java.time.OffsetDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public record NotionView(
        @JsonProperty("id") String id,
        @JsonProperty("created_time") OffsetDateTime createdTime,
        @JsonProperty("created_by") NotionUser createdBy,
        @JsonProperty("last_edited_time") OffsetDateTime lastEditedTime,
        @JsonProperty("last_edited_by") NotionUser lastEditedBy,
        @JsonProperty("in_trash") boolean inTrash,

        @JsonProperty("name") String name,
        @JsonProperty("type") String type,
        @JsonProperty("parent") Parent parent,
        @JsonProperty("url") String url
) implements NotionObject {
}
