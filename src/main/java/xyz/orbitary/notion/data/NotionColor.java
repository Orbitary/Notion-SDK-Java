package xyz.orbitary.notion.data;

import java.awt.*;


public enum NotionColor {
    DEFAULT(new Color(0x373530)),
    GRAY(new Color(0x787774)),
    BROWN(new Color(0x976D57)),
    OARNGE(new Color(0xCC782F)),
    YELLOW(new Color(0xC29343)),
    GREEN(new Color(0x548164)),
    BLUE(new Color(0x487CA5)),
    PURPLE(new Color(0x8A67AB)),
    PINK(new Color(0xB35488)),
    RED(new Color(0xC4554D)),
    ;

    public final Color nativeColor;

    NotionColor(Color nativeColor) {
        this.nativeColor = nativeColor;
    }
}
