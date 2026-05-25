package xyz.orbitary.notion.model.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.orbitary.notion.model.common.RichText;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ToDoContent(
        @JsonProperty("rich_text") List<RichText> richText,
        @JsonProperty("checked") boolean checked,
        @JsonProperty("color") String color
) implements BlockContent {
}
