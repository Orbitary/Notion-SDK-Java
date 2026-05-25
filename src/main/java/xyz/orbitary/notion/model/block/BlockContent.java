package xyz.orbitary.notion.model.block;

/**
 * Marker interface for typed block content. Use {@link NotionBlock#getContent(Class)} to deserialize.
 *
 * <table>
 * <tr><th>Block type</th><th>Content class</th></tr>
 * <tr><td>paragraph</td><td>{@link ParagraphContent}</td></tr>
 * <tr><td>heading_1 / heading_2 / heading_3</td><td>{@link HeadingContent}</td></tr>
 * <tr><td>bulleted_list_item</td><td>{@link BulletedListItemContent}</td></tr>
 * <tr><td>numbered_list_item</td><td>{@link NumberedListItemContent}</td></tr>
 * <tr><td>to_do</td><td>{@link ToDoContent}</td></tr>
 * <tr><td>toggle</td><td>{@link ToggleContent}</td></tr>
 * <tr><td>quote</td><td>{@link QuoteContent}</td></tr>
 * <tr><td>callout</td><td>{@link CalloutContent}</td></tr>
 * <tr><td>code</td><td>{@link CodeContent}</td></tr>
 * <tr><td>image</td><td>{@link ImageContent}</td></tr>
 * <tr><td>video</td><td>{@link VideoContent}</td></tr>
 * <tr><td>file</td><td>{@link FileContent}</td></tr>
 * <tr><td>pdf</td><td>{@link PdfContent}</td></tr>
 * <tr><td>audio</td><td>{@link AudioContent}</td></tr>
 * <tr><td>bookmark</td><td>{@link BookmarkContent}</td></tr>
 * <tr><td>divider</td><td>{@link DividerContent}</td></tr>
 * <tr><td>table</td><td>{@link TableContent}</td></tr>
 * <tr><td>table_row</td><td>{@link TableRowContent}</td></tr>
 * <tr><td>column_list</td><td>{@link ColumnListContent}</td></tr>
 * <tr><td>column</td><td>{@link ColumnContent}</td></tr>
 * <tr><td>child_page</td><td>{@link ChildPageContent}</td></tr>
 * <tr><td>child_database</td><td>{@link ChildDatabaseContent}</td></tr>
 * <tr><td>embed</td><td>{@link EmbedContent}</td></tr>
 * <tr><td>link_preview</td><td>{@link LinkPreviewContent}</td></tr>
 * <tr><td>synced_block</td><td>{@link SyncedBlockContent}</td></tr>
 * <tr><td>template</td><td>{@link TemplateContent}</td></tr>
 * <tr><td>link_to_page</td><td>{@link LinkToPageContent}</td></tr>
 * <tr><td>table_of_contents</td><td>{@link TableOfContentsContent}</td></tr>
 * <tr><td>breadcrumb</td><td>{@link BreadcrumbContent}</td></tr>
 * <tr><td>equation</td><td>{@link EquationContent}</td></tr>
 * <tr><td>unsupported</td><td>{@link UnsupportedContent}</td></tr>
 * </table>
 */
public interface BlockContent {
}
