package xyz.orbitary.notion.model.block;

import com.fasterxml.jackson.annotation.*;
import org.jetbrains.annotations.Nullable;
import xyz.orbitary.notion.model.common.NotionObject;
import xyz.orbitary.notion.model.common.Parent;
import xyz.orbitary.notion.model.user.NotionUser;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

import static xyz.bitsquidd.bits.util.serializer.SerializationManager.SERIALIZER;


@JsonIgnoreProperties(ignoreUnknown = false)
public class NotionBlock implements NotionObject {
    private final String id;
    private final OffsetDateTime createdTime;
    private final NotionUser createdBy;
    private final OffsetDateTime lastEditedTime;
    private final NotionUser lastEditedBy;
    private final @Nullable Boolean inTrash;
    private final String type;
    private final Parent parent;
    private final boolean hasChildren;
    private final Map<String, Object> content = new HashMap<>();

    @JsonCreator
    public NotionBlock(
            @JsonProperty("id") String id,
            @JsonProperty("created_time") OffsetDateTime createdTime,
            @JsonProperty("created_by") NotionUser createdBy,
            @JsonProperty("last_edited_time") OffsetDateTime lastEditedTime,
            @JsonProperty("last_edited_by") NotionUser lastEditedBy,
            @JsonProperty("in_trash") @Nullable Boolean inTrash,

            @JsonProperty("type") String type,
            @JsonProperty("parent") Parent parent,
            @JsonProperty("has_children") boolean hasChildren
    ) {
        this.id = id;
        this.createdTime = createdTime;
        this.createdBy = createdBy;
        this.lastEditedTime = lastEditedTime;
        this.lastEditedBy = lastEditedBy;
        this.inTrash = inTrash;
        this.type = type;
        this.parent = parent;
        this.hasChildren = hasChildren;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public OffsetDateTime createdTime() {
        return createdTime;
    }

    @Override
    public NotionUser createdBy() {
        return createdBy;
    }

    @Override
    public OffsetDateTime lastEditedTime() {
        return lastEditedTime;
    }

    @Override
    public NotionUser lastEditedBy() {
        return lastEditedBy;
    }

    @Override
    public @Nullable Boolean inTrash() {
        return inTrash;
    }

    public String type() {
        return type;
    }

    public Parent parent() {
        return parent;
    }

    public boolean hasChildren() {
        return hasChildren;
    }

    @JsonAnySetter
    public void setContent(String key, Object value) {
        content.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getRawContent() {
        return content;
    }

    public @Nullable Object getTypeContent() {
        return content.get(type);
    }

    public <T extends BlockContent> @Nullable T getContent(Class<T> contentClass) {
        Object raw = getTypeContent();
        if (raw == null) return null;
        return SERIALIZER.convertValue(raw, contentClass);
    }

}
