package xyz.orbitary.notion.model.database.property;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertySchema {
    private String id;
    private String name;
    private String description;
    private String type;

    @JsonProperty("select")
    private JsonNode select;
    @JsonProperty("multi_select")
    private JsonNode multiSelect;
    @JsonProperty("status")
    private JsonNode status;
    @JsonProperty("relation")
    private JsonNode relation;
    @JsonProperty("rollup")
    private JsonNode rollup;
    @JsonProperty("formula")
    private JsonNode formula;
    @JsonProperty("number")
    private JsonNode number;
    @JsonProperty("unique_id")
    private JsonNode uniqueId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JsonNode getSelect() {
        return select;
    }

    public void setSelect(JsonNode v) {
        this.select = v;
    }

    public JsonNode getMultiSelect() {
        return multiSelect;
    }

    public void setMultiSelect(JsonNode v) {
        this.multiSelect = v;
    }

    public JsonNode getStatus() {
        return status;
    }

    public void setStatus(JsonNode v) {
        this.status = v;
    }

    public JsonNode getRelation() {
        return relation;
    }

    public void setRelation(JsonNode v) {
        this.relation = v;
    }

    public JsonNode getRollup() {
        return rollup;
    }

    public void setRollup(JsonNode v) {
        this.rollup = v;
    }

    public JsonNode getFormula() {
        return formula;
    }

    public void setFormula(JsonNode v) {
        this.formula = v;
    }

    public JsonNode getNumber() {
        return number;
    }

    public void setNumber(JsonNode v) {
        this.number = v;
    }

    public JsonNode getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(JsonNode v) {
        this.uniqueId = v;
    }

}
