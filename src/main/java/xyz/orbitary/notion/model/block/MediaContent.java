package xyz.orbitary.notion.model.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;
import xyz.orbitary.notion.model.common.RichText;

import java.util.List;


public interface MediaContent extends BlockContent {
    @Nullable String type();

    @Nullable FileRef external();

    @Nullable FileRef file();

    List<RichText> caption();

    default @Nullable String url() {
        return switch (type() != null ? type() : "") {
            case "external" -> external() != null ? external().url() : null;
            case "file" -> file() != null ? file().url() : null;
            default -> null;
        };
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    record FileRef(
            @JsonProperty("url") String url,
            @JsonProperty("expiry_time") String expiryTime
    ) {
    }

}
