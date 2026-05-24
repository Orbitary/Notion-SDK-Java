package xyz.orbitary.notion.model.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.common.Icon;
import xyz.orbitary.notion.model.common.NotionObject;
import xyz.orbitary.notion.model.common.Parent;
import xyz.orbitary.notion.model.common.RichText;
import xyz.orbitary.notion.model.database.property.PropertySchema;

import java.util.List;
import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class NotionDatabase extends NotionObject {
    private List<RichText> title;
    private List<RichText> description;
    private Parent parent;
    private Map<String, PropertySchema> properties;
    private String url;
    @JsonProperty("public_url")
    private String publicUrl;
    @JsonProperty("is_inline")
    private boolean inline;
    @JsonProperty("is_locked")
    private boolean locked;
    private Icon icon;
    private Icon cover;

    public List<RichText> getTitle() {
        return title;
    }

    public void setTitle(List<RichText> title) {
        this.title = title;
    }

    public String getTitleText() {
        return RichText.plainText(title);
    }

    public List<RichText> getDescription() {
        return description;
    }

    public void setDescription(List<RichText> description) {
        this.description = description;
    }

    public String getDescriptionText() {
        return RichText.plainText(description);
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Map<String, PropertySchema> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, PropertySchema> properties) {
        this.properties = properties;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublicUrl() {
        return publicUrl;
    }

    public void setPublicUrl(String v) {
        this.publicUrl = v;
    }

    public boolean isInline() {
        return inline;
    }

    public void setInline(boolean inline) {
        this.inline = inline;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Icon getCover() {
        return cover;
    }

    public void setCover(Icon cover) {
        this.cover = cover;
    }

}
