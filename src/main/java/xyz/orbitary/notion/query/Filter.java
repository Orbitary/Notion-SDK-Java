package xyz.orbitary.notion.query;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Filter {
    private final Map<String, Object> json;

    private Filter(Map<String, Object> json) {
        this.json = json;
    }

    public static PropertyFilter property(String name) {
        return new PropertyFilter(name);
    }

    public static Filter and(Filter... filters) {
        List<Map<String, Object>> list = Arrays.stream(filters).map(Filter::toJson).collect(Collectors.toList());
        Map<String, Object> json = new HashMap<>();
        json.put("and", list);
        return new Filter(json);
    }

    public static Filter or(Filter... filters) {
        List<Map<String, Object>> list = Arrays.stream(filters).map(Filter::toJson).collect(Collectors.toList());
        Map<String, Object> json = new HashMap<>();
        json.put("or", list);
        return new Filter(json);
    }

    public Map<String, Object> toJson() {
        return json;
    }

    private static Filter make(String property, String filterType, String condition, Object value) {
        Map<String, Object> inner = new HashMap<>();
        inner.put(condition, value);
        Map<String, Object> outer = new HashMap<>();
        outer.put("property", property);
        outer.put(filterType, inner);
        return new Filter(outer);
    }

    private static Filter makeFlag(String property, String filterType, String condition) {
        return make(property, filterType, condition, true);
    }

    public static class PropertyFilter {
        private final String name;

        PropertyFilter(String name) {
            this.name = name;
        }

        public StatusFilter status() {
            return new StatusFilter(name);
        }

        public PeopleFilter people() {
            return new PeopleFilter(name);
        }

        public TextFilter richText() {
            return new TextFilter(name, "rich_text");
        }

        public TextFilter title() {
            return new TextFilter(name, "title");
        }

        public SelectFilter select() {
            return new SelectFilter(name);
        }

        public MultiSelectFilter multiSelect() {
            return new MultiSelectFilter(name);
        }

        public DateFilter date() {
            return new DateFilter(name);
        }

        public CheckboxFilter checkbox() {
            return new CheckboxFilter(name);
        }

        public NumberFilter number() {
            return new NumberFilter(name);
        }

        public RelationFilter relation() {
            return new RelationFilter(name);
        }

    }

    public static class StatusFilter {
        private final String name;

        StatusFilter(String name) {
            this.name = name;
        }

        public Filter equals(String value) {
            return make(name, "status", "equals", value);
        }

        public Filter doesNotEqual(String value) {
            return make(name, "status", "does_not_equal", value);
        }

        public Filter isEmpty() {
            return makeFlag(name, "status", "is_empty");
        }

        public Filter isNotEmpty() {
            return makeFlag(name, "status", "is_not_empty");
        }

    }

    public static class PeopleFilter {
        private final String name;

        PeopleFilter(String name) {
            this.name = name;
        }

        public Filter contains(String userId) {
            return make(name, "people", "contains", userId);
        }

        public Filter doesNotContain(String userId) {
            return make(name, "people", "does_not_contain", userId);
        }

        public Filter isEmpty() {
            return makeFlag(name, "people", "is_empty");
        }

        public Filter isNotEmpty() {
            return makeFlag(name, "people", "is_not_empty");
        }

    }

    public static class TextFilter {
        private final String name;
        private final String filterType;

        TextFilter(String name, String filterType) {
            this.name = name;
            this.filterType = filterType;
        }

        public Filter equals(String value) {
            return make(name, filterType, "equals", value);
        }

        public Filter doesNotEqual(String value) {
            return make(name, filterType, "does_not_equal", value);
        }

        public Filter contains(String value) {
            return make(name, filterType, "contains", value);
        }

        public Filter doesNotContain(String value) {
            return make(name, filterType, "does_not_contain", value);
        }

        public Filter startsWith(String value) {
            return make(name, filterType, "starts_with", value);
        }

        public Filter endsWith(String value) {
            return make(name, filterType, "ends_with", value);
        }

        public Filter isEmpty() {
            return makeFlag(name, filterType, "is_empty");
        }

        public Filter isNotEmpty() {
            return makeFlag(name, filterType, "is_not_empty");
        }

    }

    public static class SelectFilter {
        private final String name;

        SelectFilter(String name) {
            this.name = name;
        }

        public Filter equals(String value) {
            return make(name, "select", "equals", value);
        }

        public Filter doesNotEqual(String value) {
            return make(name, "select", "does_not_equal", value);
        }

        public Filter isEmpty() {
            return makeFlag(name, "select", "is_empty");
        }

        public Filter isNotEmpty() {
            return makeFlag(name, "select", "is_not_empty");
        }

    }

    public static class MultiSelectFilter {
        private final String name;

        MultiSelectFilter(String name) {
            this.name = name;
        }

        public Filter contains(String value) {
            return make(name, "multi_select", "contains", value);
        }

        public Filter doesNotContain(String value) {
            return make(name, "multi_select", "does_not_contain", value);
        }

        public Filter isEmpty() {
            return makeFlag(name, "multi_select", "is_empty");
        }

        public Filter isNotEmpty() {
            return makeFlag(name, "multi_select", "is_not_empty");
        }

    }

    public static class DateFilter {
        private final String name;

        DateFilter(String name) {
            this.name = name;
        }

        public Filter equals(String date) {
            return make(name, "date", "equals", date);
        }

        public Filter before(String date) {
            return make(name, "date", "before", date);
        }

        public Filter after(String date) {
            return make(name, "date", "after", date);
        }

        public Filter onOrBefore(String date) {
            return make(name, "date", "on_or_before", date);
        }

        public Filter onOrAfter(String date) {
            return make(name, "date", "on_or_after", date);
        }

        public Filter pastWeek() {
            return make(name, "date", "past_week", new HashMap<>());
        }

        public Filter pastMonth() {
            return make(name, "date", "past_month", new HashMap<>());
        }

        public Filter nextWeek() {
            return make(name, "date", "next_week", new HashMap<>());
        }

        public Filter nextMonth() {
            return make(name, "date", "next_month", new HashMap<>());
        }

        public Filter isEmpty() {
            return makeFlag(name, "date", "is_empty");
        }

        public Filter isNotEmpty() {
            return makeFlag(name, "date", "is_not_empty");
        }

    }

    public static class CheckboxFilter {
        private final String name;

        CheckboxFilter(String name) {
            this.name = name;
        }

        public Filter isTrue() {
            return make(name, "checkbox", "equals", true);
        }

        public Filter isFalse() {
            return make(name, "checkbox", "equals", false);
        }

    }

    public static class NumberFilter {
        private final String name;

        NumberFilter(String name) {
            this.name = name;
        }

        public Filter equals(Number value) {
            return make(name, "number", "equals", value);
        }

        public Filter doesNotEqual(Number value) {
            return make(name, "number", "does_not_equal", value);
        }

        public Filter greaterThan(Number value) {
            return make(name, "number", "greater_than", value);
        }

        public Filter lessThan(Number value) {
            return make(name, "number", "less_than", value);
        }

        public Filter greaterThanOrEqualTo(Number value) {
            return make(name, "number", "greater_than_or_equal_to", value);
        }

        public Filter lessThanOrEqualTo(Number value) {
            return make(name, "number", "less_than_or_equal_to", value);
        }

        public Filter isEmpty() {
            return makeFlag(name, "number", "is_empty");
        }

        public Filter isNotEmpty() {
            return makeFlag(name, "number", "is_not_empty");
        }

    }

    public static class RelationFilter {
        private final String name;

        RelationFilter(String name) {
            this.name = name;
        }

        public Filter contains(String pageId) {
            return make(name, "relation", "contains", pageId);
        }

        public Filter doesNotContain(String pageId) {
            return make(name, "relation", "does_not_contain", pageId);
        }

        public Filter isEmpty() {
            return makeFlag(name, "relation", "is_empty");
        }

        public Filter isNotEmpty() {
            return makeFlag(name, "relation", "is_not_empty");
        }

    }

}
