package ch02.item06;

import java.util.regex.Pattern;

public class RomanNumerals {

    // 초기화 시 Pattern 객체를 한번만 생성한다.
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    // 호출할 때마다 내부에서 생성 비용이 높은 Pattern 인스턴스를 생성한다.
    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    // final 객체를 사용하여 비교 연산을 수행한다.
    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }
}
