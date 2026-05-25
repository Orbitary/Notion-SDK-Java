package xyz.orbitary.notion.model.database.property;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;


@JsonIgnoreProperties(ignoreUnknown = true)
public record SelectOption(
        @JsonProperty("id") @Nullable String id,
        @JsonProperty("name") @Nullable String name,
        @JsonProperty("color") @Nullable String color
) {
}
