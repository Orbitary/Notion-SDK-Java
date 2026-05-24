package xyz.orbitary.notion.model.page;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.common.Icon;
import xyz.orbitary.notion.model.common.NotionObject;
import xyz.orbitary.notion.model.common.Parent;

import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class NotionPage extends NotionObject {

    private Parent parent;
    private Map<String, Object> properties;
    private String url;
    @JsonProperty("public_url")
    private String publicUrl;
    private boolean archived;
    private Icon icon;
    private Icon cover;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
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

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
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
