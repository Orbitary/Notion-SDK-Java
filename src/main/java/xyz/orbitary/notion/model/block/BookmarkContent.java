package xyz.orbitary.notion.model.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.common.RichText;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record BookmarkContent(
        @JsonProperty("url") String url,
        @JsonProperty("caption") List<RichText> caption
) implements BlockContent {
}
