package xyz.orbitary.notion.model.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;
import xyz.orbitary.notion.model.common.NotionObject;
import xyz.orbitary.notion.model.common.Parent;
import xyz.orbitary.notion.model.user.NotionUser;

import java.time.OffsetDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public record NotionView(
        @JsonProperty("id") String id,
        @JsonProperty("created_time") @Nullable OffsetDateTime createdTime,
        @JsonProperty("created_by") @Nullable NotionUser createdBy,
        @JsonProperty("last_edited_time") @Nullable OffsetDateTime lastEditedTime,
        @JsonProperty("last_edited_by") @Nullable NotionUser lastEditedBy,
        @JsonProperty("in_trash") @Nullable Boolean inTrash,

        @JsonProperty("name") String name,
        @JsonProperty("type") String type,
        @JsonProperty("parent") Parent parent,
        @JsonProperty("url") String url
) implements NotionObject {
}
