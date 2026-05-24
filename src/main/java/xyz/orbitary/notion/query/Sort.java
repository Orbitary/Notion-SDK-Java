package xyz.orbitary.notion.query;

import java.util.HashMap;
import java.util.Map;


public class Sort {
    private final Map<String, Object> json;

    private Sort(Map<String, Object> json) {
        this.json = json;
    }

    public static SortBuilder property(String name) {
        return new SortBuilder(name);
    }

    public static Sort byCreatedTime(String direction) {
        Map<String, Object> json = new HashMap<>();
        json.put("timestamp", "created_time");
        json.put("direction", direction);
        return new Sort(json);
    }

    public static Sort byLastEditedTime(String direction) {
        Map<String, Object> json = new HashMap<>();
        json.put("timestamp", "last_edited_time");
        json.put("direction", direction);
        return new Sort(json);
    }

    public Map<String, Object> toJson() {
        return json;
    }

    public static class SortBuilder {
        private final String name;

        SortBuilder(String name) {
            this.name = name;
        }

        public Sort ascending() {
            Map<String, Object> json = new HashMap<>();
            json.put("property", name);
            json.put("direction", "ascending");
            return new Sort(json);
        }

        public Sort descending() {
            Map<String, Object> json = new HashMap<>();
            json.put("property", name);
            json.put("direction", "descending");
            return new Sort(json);
        }

    }

}
