package ch06.item40;

import java.util.HashSet;
import java.util.Set;

// 알파벳 2개로 구성된 문자열을 표현하는 클래스
public class BigramV2 {
    private final char first;
    private final char second;

    public BigramV2(char first, char second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BigramV2))
            return false;
        BigramV2 b = (BigramV2) o;
        return this.first == b.first && this.second == b.second;
    }

    @Override
    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<BigramV2> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z' ; ch++) {
                s.add(new BigramV2(ch, ch));
            }
        }
        System.out.println(s.size()); // 26
    }
}
