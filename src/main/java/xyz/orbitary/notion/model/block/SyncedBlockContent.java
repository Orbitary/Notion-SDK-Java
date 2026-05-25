package xyz.orbitary.notion.model.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;


@JsonIgnoreProperties(ignoreUnknown = true)
public record SyncedBlockContent(
        @JsonProperty("synced_from") @Nullable SyncedFrom syncedFrom
) implements BlockContent {
    public boolean isOriginal() {
        return syncedFrom == null;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record SyncedFrom(
            @JsonProperty("type") String type,
            @JsonProperty("block_id") String blockId
    ) {
    }

}
