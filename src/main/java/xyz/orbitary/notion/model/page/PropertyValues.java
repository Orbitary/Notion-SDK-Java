package xyz.orbitary.notion.model.page;

import com.fasterxml.jackson.core.type.TypeReference;
import org.jetbrains.annotations.Nullable;
import xyz.orbitary.notion.model.common.RichText;
import xyz.orbitary.notion.model.database.property.SelectOption;
import xyz.orbitary.notion.model.user.NotionUser;

import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;

import static xyz.bitsquidd.bits.util.serializer.SerializationManager.SERIALIZER;


public final class PropertyValues {
    private PropertyValues() {
    }

    public static List<NotionUser> people(Map<String, Object> props, String key) {
        return list(props, key, "people", new TypeReference<>() {
        });
    }

    public static List<RichText> title(Map<String, Object> props, String key) {
        return list(props, key, "title", new TypeReference<>() {
        });
    }

    public static String titlePlain(Map<String, Object> props, String key) {
        return RichText.plainText(title(props, key));
    }

    public static List<RichText> richText(Map<String, Object> props, String key) {
        return list(props, key, "rich_text", new TypeReference<>() {
        });
    }

    public static @Nullable String richTextPlain(Map<String, Object> props, String key) {
        List<RichText> items = richText(props, key);
        return items.isEmpty() ? null : items.get(0).plainText();
    }

    public static @Nullable SelectOption select(Map<String, Object> props, String key) {
        Map<String, Object> prop = prop(props, key);
        if (prop == null) return null;
        Object raw = prop.get("select");
        if (raw == null) return null;
        return SERIALIZER.convertValue(raw, SelectOption.class);
    }

    public static @Nullable String selectName(Map<String, Object> props, String key) {
        SelectOption opt = select(props, key);
        return opt != null ? opt.name() : null;
    }

    public static List<SelectOption> multiSelect(Map<String, Object> props, String key) {
        return list(props, key, "multi_select", new TypeReference<>() {
        });
    }

    public static List<String> multiSelectNames(Map<String, Object> props, String key) {
        return multiSelect(props, key).stream().map(SelectOption::name).toList();
    }

    public static @Nullable SelectOption status(Map<String, Object> props, String key) {
        Map<String, Object> prop = prop(props, key);
        if (prop == null) return null;
        Object raw = prop.get("status");
        if (raw == null) return null;
        return SERIALIZER.convertValue(raw, SelectOption.class);
    }

    public static @Nullable String statusName(Map<String, Object> props, String key) {
        SelectOption opt = status(props, key);
        return opt != null ? opt.name() : null;
    }

    public static @Nullable Instant date(Map<String, Object> props, String key) {
        Map<String, Object> prop = prop(props, key);
        if (prop == null) return null;
        @SuppressWarnings("unchecked")
        Map<String, Object> d = prop.get("date") instanceof Map m ? (Map<String, Object>) m : null;
        if (d == null) return null;
        String start = d.get("start") instanceof String s ? s : null;
        if (start == null) return null;
        if (start.contains("T")) return OffsetDateTime.parse(start).toInstant();
        return LocalDate.parse(start).atStartOfDay(ZoneOffset.UTC).toInstant();
    }

    public static @Nullable Double number(Map<String, Object> props, String key) {
        Map<String, Object> prop = prop(props, key);
        if (prop == null) return null;
        Object raw = prop.get("number");
        if (raw == null) return null;
        return ((Number) raw).doubleValue();
    }

    public static boolean checkbox(Map<String, Object> props, String key) {
        Map<String, Object> prop = prop(props, key);
        if (prop == null) return false;
        Object raw = prop.get("checkbox");
        return raw instanceof Boolean b && b;
    }

    public static @Nullable String url(Map<String, Object> props, String key) {
        return string(props, key, "url");
    }

    public static @Nullable String email(Map<String, Object> props, String key) {
        return string(props, key, "email");
    }

    public static @Nullable String phone(Map<String, Object> props, String key) {
        return string(props, key, "phone_number");
    }

    private static <T> List<T> list(Map<String, Object> props, String key, String subKey, TypeReference<List<T>> ref) {
        Map<String, Object> prop = prop(props, key);
        if (prop == null) return List.of();
        Object raw = prop.get(subKey);
        if (raw == null) return List.of();
        return SERIALIZER.convertValue(raw, ref);
    }

    private static @Nullable String string(Map<String, Object> props, String key, String subKey) {
        Map<String, Object> prop = prop(props, key);
        if (prop == null) return null;
        Object raw = prop.get(subKey);
        return raw instanceof String s ? s : null;
    }

    @SuppressWarnings("unchecked")
    private static @Nullable Map<String, Object> prop(Map<String, Object> props, String key) {
        Object val = props.get(key);
        return val instanceof Map ? (Map<String, Object>) val : null;
    }

}
