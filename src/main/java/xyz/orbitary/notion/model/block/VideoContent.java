package xyz.orbitary.notion.model.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.common.RichText;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record VideoContent(
        @JsonProperty("type") String type,
        @JsonProperty("external") MediaContent.FileRef external,
        @JsonProperty("file") MediaContent.FileRef file,
        @JsonProperty("caption") List<RichText> caption
) implements MediaContent {
}
