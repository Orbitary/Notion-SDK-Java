package xyz.orbitary.notion.model.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.common.Icon;
import xyz.orbitary.notion.model.common.RichText;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record CalloutContent(
        @JsonProperty("rich_text") List<RichText> richText,
        @JsonProperty("icon") Icon icon,
        @JsonProperty("color") String color
) implements BlockContent {
}
