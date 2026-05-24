package xyz.orbitary.notion.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.common.NotionObject;


@JsonIgnoreProperties(ignoreUnknown = true)
public class NotionUser extends NotionObject {
    private String name;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    private String type;
    private Person person;
    private Bot bot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String v) {
        this.avatarUrl = v;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public boolean isPerson() {
        return "person".equals(type);
    }

    public boolean isBot() {
        return "bot".equals(type);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Person {
        private String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Bot {
        @JsonProperty("workspace_id")
        private String workspaceId;
        @JsonProperty("workspace_name")
        private String workspaceName;

        public String getWorkspaceId() {
            return workspaceId;
        }

        public void setWorkspaceId(String v) {
            this.workspaceId = v;
        }

        public String getWorkspaceName() {
            return workspaceName;
        }

        public void setWorkspaceName(String v) {
            this.workspaceName = v;
        }

    }

}
