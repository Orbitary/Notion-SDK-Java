package xyz.orbitary.notion.model.block;

/**
 * Marker interface for typed block content.
 *
 * <p>
 * <ul>
 *   <li>ParagraphContent — rich_text, color, children</li>
 *   <li>Heading1Content, Heading2Content, Heading3Content — rich_text, color, is_toggleable</li>
 *   <li>BulletedListItemContent — rich_text, color, children</li>
 *   <li>NumberedListItemContent — rich_text, color, children</li>
 *   <li>QuoteContent — rich_text, color, children</li>
 *   <li>CalloutContent — rich_text, icon, color, children</li>
 *   <li>ToggleContent — rich_text, color, children</li>
 *   <li>CodeContent — rich_text, caption, language</li>
 *   <li>ImageContent — type, external/file URL, caption</li>
 *   <li>VideoContent — type, external/file URL, caption</li>
 *   <li>FileContent — type, external/file URL, caption, name</li>
 *   <li>BookmarkContent — url, caption</li>
 *   <li>DividerContent — (empty)</li>
 *   <li>TableContent — table_width, has_column_header, has_row_header</li>
 *   <li>TableRowContent — cells (list of list of rich text)</li>
 *   <li>ColumnListContent — (empty, children are columns)</li>
 *   <li>ColumnContent — (empty, children are blocks)</li>
 *   <li>ChildPageContent — title</li>
 *   <li>ChildDatabaseContent — title</li>
 *   <li>EmbedContent — url</li>
 *   <li>LinkPreviewContent — url</li>
 *   <li>SyncedBlockContent — synced_from (block_id or null for original)</li>
 *   <li>TemplateContent — rich_text, children</li>
 *   <li>LinkToPageContent — type, page_id or database_id</li>
 *   <li>TableOfContentsContent — color</li>
 *   <li>BreadcrumbContent — (empty)</li>
 *   <li>UnsupportedContent — (empty)</li>
 * </ul>
 *
 * <p>Until this hierarchy is implemented, access block type-specific data via
 * {@link NotionBlock#getRawContent()}.
 */
public interface BlockContent {
    // TODO: Implement a full typed hierarchy for each Notion block type.
}
