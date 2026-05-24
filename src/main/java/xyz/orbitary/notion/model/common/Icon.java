package xyz.orbitary.notion.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Icon {
    private String type;
    private String emoji;
    private FileObject external;
    private FileObject file;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public FileObject getExternal() {
        return external;
    }

    public void setExternal(FileObject v) {
        this.external = v;
    }

    public FileObject getFile() {
        return file;
    }

    public void setFile(FileObject file) {
        this.file = file;
    }

    public String getUrl() {
        if (type == null) return null;
        return switch (type) {
            case "emoji" -> emoji;
            case "external" -> external != null ? external.getUrl() : null;
            case "file" -> file != null ? file.getUrl() : null;
            default -> null;
        };
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FileObject {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

}
