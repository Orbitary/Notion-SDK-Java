package xyz.orbitary.notion;

import org.jetbrains.annotations.Nullable;
import xyz.bitsquidd.bits.exception.BitsException;
import xyz.orbitary.notion.http.NotionHttpClient;
import xyz.orbitary.notion.resource.*;


public class Notion {
    private static @Nullable Notion instance;

    private final NotionHttpClient http;
    private final UserResource users;
    private final DatabaseResource databases;
    private final PageResource pages;
    private final BlockResource blocks;
    private final CommentResource comments;
    private final SearchResource search;
    private final ViewResource views;

    public Notion(String token) {
        if (instance != null) throw BitsException.INSTANCE_ALREADY_EXISTS(Notion.class);
        instance = this;

        this.http = new NotionHttpClient(token);

        // Resources
        this.users = new UserResource();
        this.databases = new DatabaseResource();
        this.pages = new PageResource();
        this.blocks = new BlockResource();
        this.comments = new CommentResource();
        this.search = new SearchResource();
        this.views = new ViewResource();
    }

    public static Notion get() {
        if (instance == null) throw BitsException.INSTANCE_NOT_FOUND(Notion.class);
        return instance;
    }

    public NotionHttpClient http() {
        return http;
    }

    public UserResource users() {
        return users;
    }

    public DatabaseResource databases() {
        return databases;
    }

    public PageResource pages() {
        return pages;
    }

    public BlockResource blocks() {
        return blocks;
    }

    public CommentResource comments() {
        return comments;
    }

    public SearchResource search() {
        return search;
    }

    public ViewResource views() {
        return views;
    }

}
