package xyz.orbitary.notion.model.database.property;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;


@JsonIgnoreProperties(ignoreUnknown = true)
public record PropertySchema(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("type") String type,
        @JsonProperty("select") JsonNode select,
        @JsonProperty("multi_select") JsonNode multiSelect,
        @JsonProperty("status") JsonNode status,
        @JsonProperty("relation") JsonNode relation,
        @JsonProperty("rollup") JsonNode rollup,
        @JsonProperty("formula") JsonNode formula,
        @JsonProperty("number") JsonNode number,
        @JsonProperty("unique_id") JsonNode uniqueId
) {
}
