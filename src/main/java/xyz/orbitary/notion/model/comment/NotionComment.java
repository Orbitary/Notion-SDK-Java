package xyz.orbitary.notion.model.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.common.NotionObject;
import xyz.orbitary.notion.model.common.Parent;
import xyz.orbitary.notion.model.common.RichText;
import xyz.orbitary.notion.model.user.NotionUser;

import java.time.OffsetDateTime;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record NotionComment(
        @JsonProperty("id") String id,
        @JsonProperty("created_time") OffsetDateTime createdTime,
        @JsonProperty("created_by") NotionUser createdBy,
        @JsonProperty("last_edited_time") OffsetDateTime lastEditedTime,
        @JsonProperty("last_edited_by") NotionUser lastEditedBy,
        @JsonProperty("in_trash") boolean inTrash,

        @JsonProperty("parent") Parent parent,
        @JsonProperty("discussion_id") String discussionId,
        @JsonProperty("rich_text") List<RichText> richText,
        @JsonProperty("display_name") String displayName
) implements NotionObject {
    public String plainText() {
        return RichText.plainText(richText);
    }

}
