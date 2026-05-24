package xyz.orbitary.notion.model.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import xyz.orbitary.notion.model.common.NotionObject;
import xyz.orbitary.notion.model.common.Parent;


@JsonIgnoreProperties(ignoreUnknown = true)
public class NotionView extends NotionObject {
    private String name;
    private String type;
    private Parent parent;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
