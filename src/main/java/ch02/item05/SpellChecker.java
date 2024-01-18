package ch02.item05;

import java.util.Objects;

/**
 * 의존 객체 주입
 *  - 유연성과 테스트 용이성을 높여줌.
 */
public class SpellChecker {
    private final Lexicon dictionary; // 자원

    // 생성자를 통해 자원을 주입받음.
    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }
}
