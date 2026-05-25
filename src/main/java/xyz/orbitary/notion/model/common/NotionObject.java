package xyz.orbitary.notion.model.common;

import xyz.orbitary.notion.model.user.NotionUser;

import java.time.OffsetDateTime;


public interface NotionObject {
    String id();

    OffsetDateTime createdTime();

    NotionUser createdBy();

    OffsetDateTime lastEditedTime();

    NotionUser lastEditedBy();

    boolean inTrash();

}
