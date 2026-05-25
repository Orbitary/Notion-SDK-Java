package xyz.orbitary.notion.model.common;

import org.jetbrains.annotations.Nullable;
import xyz.orbitary.notion.model.user.NotionUser;

import java.time.OffsetDateTime;


public interface NotionObject {
    String id();

    @Nullable OffsetDateTime createdTime();

    @Nullable NotionUser createdBy();

    @Nullable OffsetDateTime lastEditedTime();

    @Nullable NotionUser lastEditedBy();

    @Nullable Boolean inTrash();

}
