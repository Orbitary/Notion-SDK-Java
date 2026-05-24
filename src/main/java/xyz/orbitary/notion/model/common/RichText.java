package xyz.orbitary.notion.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class RichText {
    private String type;
    @JsonProperty("plain_text")
    private String plainText;
    private String href;
    private Annotations annotations;
    private TextContent text;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String v) {
        this.plainText = v;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Annotations getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotations v) {
        this.annotations = v;
    }

    public TextContent getText() {
        return text;
    }

    public void setText(TextContent text) {
        this.text = text;
    }

    public static String plainText(List<RichText> items) {
        if (items == null) return "";
        return items.stream()
                .map(rt -> rt.plainText != null ? rt.plainText : "")
                .reduce("", String::concat);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Annotations {
        private boolean bold, italic, strikethrough, underline, code;
        private String color;

        public boolean isBold() {
            return bold;
        }

        public void setBold(boolean v) {
            this.bold = v;
        }

        public boolean isItalic() {
            return italic;
        }

        public void setItalic(boolean v) {
            this.italic = v;
        }

        public boolean isStrikethrough() {
            return strikethrough;
        }

        public void setStrikethrough(boolean v) {
            this.strikethrough = v;
        }

        public boolean isUnderline() {
            return underline;
        }

        public void setUnderline(boolean v) {
            this.underline = v;
        }

        public boolean isCode() {
            return code;
        }

        public void setCode(boolean v) {
            this.code = v;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TextContent {
        private String content;
        private Link link;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Link getLink() {
            return link;
        }

        public void setLink(Link link) {
            this.link = link;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Link {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

}
