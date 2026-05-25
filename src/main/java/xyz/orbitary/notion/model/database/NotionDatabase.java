package xyz.orbitary.notion.model.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.common.Icon;
import xyz.orbitary.notion.model.common.NotionObject;
import xyz.orbitary.notion.model.common.Parent;
import xyz.orbitary.notion.model.common.RichText;
import xyz.orbitary.notion.model.database.property.PropertySchema;
import xyz.orbitary.notion.model.user.NotionUser;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public record NotionDatabase(
        @JsonProperty("id") String id,
        @JsonProperty("created_time") OffsetDateTime createdTime,
        @JsonProperty("created_by") NotionUser createdBy,
        @JsonProperty("last_edited_time") OffsetDateTime lastEditedTime,
        @JsonProperty("last_edited_by") NotionUser lastEditedBy,
        @JsonProperty("in_trash") boolean inTrash,

        @JsonProperty("title") List<RichText> title,
        @JsonProperty("description") List<RichText> description,
        @JsonProperty("parent") Parent parent,
        @JsonProperty("properties") Map<String, PropertySchema> properties,
        @JsonProperty("url") String url,
        @JsonProperty("public_url") String publicUrl,
        @JsonProperty("is_inline") boolean inline,
        @JsonProperty("is_locked") boolean locked,
        @JsonProperty("icon") Icon icon,
        @JsonProperty("cover") Icon cover
) implements NotionObject {
    public String titleText() {
        return RichText.plainText(title);
    }

    public String descriptionText() {
        return RichText.plainText(description);
    }

}
