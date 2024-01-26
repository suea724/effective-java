package ch06.item36;

import java.util.EnumSet;
import java.util.Set;

// 비트 필드 대체
public class Text {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    // 어떤 Set을 넘겨도 되지만, EnumSet이 가장 좋다.
    public void applyStyles(Set<Style> styles) {

    }

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }

}
