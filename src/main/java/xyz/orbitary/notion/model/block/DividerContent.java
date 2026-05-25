package xyz.orbitary.notion.model.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DividerContent() implements BlockContent {
}
