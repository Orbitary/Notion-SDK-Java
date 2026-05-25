package xyz.orbitary.notion.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record RichText(
        @JsonProperty("type") String type,
        @JsonProperty("plain_text") String plainText,
        @JsonProperty("href") String href,
        @JsonProperty("annotations") Annotations annotations,
        @JsonProperty("text") TextContent text
) {
    public static String plainText(List<RichText> items) {
        return items.stream()
                .map(RichText::plainText)
                .reduce("", String::concat);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Annotations(
            @JsonProperty("bold") boolean bold,
            @JsonProperty("italic") boolean italic,
            @JsonProperty("strikethrough") boolean strikethrough,
            @JsonProperty("underline") boolean underline,
            @JsonProperty("code") boolean code,
            @JsonProperty("color") String color
    ) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record TextContent(
            @JsonProperty("content") String content,
            @JsonProperty("link") Link link
    ) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Link(
            @JsonProperty("url") String url
    ) {
    }

}
