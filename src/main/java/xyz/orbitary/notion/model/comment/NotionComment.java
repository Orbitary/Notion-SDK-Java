package xyz.orbitary.notion.model.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.common.NotionObject;
import xyz.orbitary.notion.model.common.Parent;
import xyz.orbitary.notion.model.common.RichText;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class NotionComment extends NotionObject {
    private Parent parent;
    @JsonProperty("discussion_id")
    private String discussionId;
    @JsonProperty("rich_text")
    private List<RichText> richText;
    @JsonProperty("display_name")
    private String displayName;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(String v) {
        this.discussionId = v;
    }

    public List<RichText> getRichText() {
        return richText;
    }

    public void setRichText(List<RichText> v) {
        this.richText = v;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String v) {
        this.displayName = v;
    }

    public String getPlainText() {
        return RichText.plainText(richText);
    }

}
