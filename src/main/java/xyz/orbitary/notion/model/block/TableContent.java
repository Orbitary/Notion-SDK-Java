package xyz.orbitary.notion.model.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public record TableContent(
        @JsonProperty("table_width") int tableWidth,
        @JsonProperty("has_column_header") boolean hasColumnHeader,
        @JsonProperty("has_row_header") boolean hasRowHeader
) implements BlockContent {
}
