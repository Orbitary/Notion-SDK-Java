package xyz.orbitary.notion.model.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;


@JsonIgnoreProperties(ignoreUnknown = true)
public record LinkToPageContent(
        @JsonProperty("type") @Nullable String type,
        @JsonProperty("page_id") String pageId,
        @JsonProperty("database_id") String databaseId,
        @JsonProperty("comment_id") String commentId
) implements BlockContent {
    public @Nullable String targetId() {
        if (type == null) return null;
        return switch (type) {
            case "page_id" -> pageId;
            case "database_id" -> databaseId;
            case "comment_id" -> commentId;
            default -> null;
        };
    }

}
