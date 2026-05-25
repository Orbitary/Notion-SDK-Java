package xyz.orbitary.notion.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Icon(
        @JsonProperty("type") @Nullable String type,
        @JsonProperty("emoji") @Nullable String emoji,
        @JsonProperty("external") @Nullable FileObject external,
        @JsonProperty("file") @Nullable FileObject file
) {
    public @Nullable String url() {
        if (type == null) return null;
        return switch (type) {
            case "emoji" -> emoji;
            case "external" -> external != null ? external.url() : null;
            case "file" -> file != null ? file.url() : null;
            default -> null;
        };
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record FileObject(
            @JsonProperty("url") String url
    ) {
    }

}
