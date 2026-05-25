package xyz.orbitary.notion.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.common.NotionObject;

import java.time.OffsetDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public record NotionUser(
        @JsonProperty("id") String id,
        @JsonProperty("created_time") OffsetDateTime createdTime,
        @JsonProperty("created_by") NotionUser createdBy,
        @JsonProperty("last_edited_time") OffsetDateTime lastEditedTime,
        @JsonProperty("last_edited_by") NotionUser lastEditedBy,
        @JsonProperty("in_trash") boolean inTrash,

        @JsonProperty("name") String name,
        @JsonProperty("avatar_url") String avatarUrl,
        @JsonProperty("type") String type,
        @JsonProperty("person") Person person,
        @JsonProperty("bot") Bot bot
) implements NotionObject {
    public boolean isPerson() {
        return "person".equals(type);
    }

    public boolean isBot() {
        return "bot".equals(type);
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Person(
            @JsonProperty("email") String email
    ) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Bot(
            @JsonProperty("workspace_id") String workspaceId,
            @JsonProperty("workspace_name") String workspaceName
    ) {
    }

}