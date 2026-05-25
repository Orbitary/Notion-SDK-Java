package xyz.orbitary.notion.model.page;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;
import xyz.orbitary.notion.model.common.Icon;
import xyz.orbitary.notion.model.common.NotionObject;
import xyz.orbitary.notion.model.common.Parent;
import xyz.orbitary.notion.model.user.NotionUser;

import java.time.OffsetDateTime;
import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public record NotionPage(
        @JsonProperty("id") String id,
        @JsonProperty("created_time") @Nullable OffsetDateTime createdTime,
        @JsonProperty("created_by") @Nullable NotionUser createdBy,
        @JsonProperty("last_edited_time") @Nullable OffsetDateTime lastEditedTime,
        @JsonProperty("last_edited_by") @Nullable NotionUser lastEditedBy,
        @JsonProperty("in_trash") @Nullable Boolean inTrash,

        @JsonProperty("parent") Parent parent,
        @JsonProperty("properties") Map<String, Object> properties,
        @JsonProperty("url") String url,
        @JsonProperty("public_url") String publicUrl,
        @JsonProperty("archived") boolean archived,
        @JsonProperty("icon") Icon icon,
        @JsonProperty("cover") Icon cover
) implements NotionObject {
}
