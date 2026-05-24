package xyz.orbitary.notion.model.block;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.common.NotionObject;
import xyz.orbitary.notion.model.common.Parent;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = false)
public class NotionBlock extends NotionObject {

    private String type;
    private Parent parent;
    @JsonProperty("has_children") private boolean hasChildren;
    private final Map<String, Object> content = new HashMap<>();

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Parent getParent() { return parent; }
    public void setParent(Parent parent) { this.parent = parent; }
    public boolean isHasChildren() { return hasChildren; }
    public void setHasChildren(boolean v) { this.hasChildren = v; }

    @JsonAnySetter
    public void setContent(String key, Object value) {
        content.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getRawContent() { return content; }

    public Object getTypeContent() { return content.get(type); }
}
