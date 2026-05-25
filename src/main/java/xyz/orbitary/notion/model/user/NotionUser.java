package xyz.orbitary.notion.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;
import xyz.orbitary.notion.model.common.NotionObject;

import java.time.OffsetDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public record NotionUser(
        @JsonProperty("id") String id,
        @JsonProperty("created_time") @Nullable OffsetDateTime createdTime,
        @JsonProperty("created_by") @Nullable NotionUser createdBy,
        @JsonProperty("last_edited_time") @Nullable OffsetDateTime lastEditedTime,
        @JsonProperty("last_edited_by") @Nullable NotionUser lastEditedBy,
        @JsonProperty("in_trash") @Nullable Boolean inTrash,

        @JsonProperty("name") @Nullable String name,
        @JsonProperty("avatar_url") @Nullable String avatarUrl,
        @JsonProperty("type") @Nullable String type,
        @JsonProperty("person") @Nullable Person person,
        @JsonProperty("bot") @Nullable Bot bot
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