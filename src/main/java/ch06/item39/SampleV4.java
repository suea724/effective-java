package ch06.item39;

import java.util.ArrayList;
import java.util.List;

/**
 * 반복 가능 애너테이션을 사용한 프로그램
 */
public class SampleV4 {
    @ExceptionTestRepeatable(ArithmeticException.class)
    public static void m1() {  // 성공해야 한다.
        int i = 0;
        i = i / i;
    }

    @ExceptionTestRepeatable(ArithmeticException.class)
    public static void m2() {  // 실패해야 한다. (다른 예외 발생)
        int[] a = new int[0];
        int i = a[1];
    }

    // 코드 39-9 반복 가능 애너테이션을 두 번 단 코드 (244쪽)
    @ExceptionTestRepeatable(IndexOutOfBoundsException.class)
    @ExceptionTestRepeatable(NullPointerException.class)
    public static void doublyBad() {
        List<String> list = new ArrayList<>();

        // 자바 API 명세에 따르면 다음 메서드는 IndexOutOfBoundsException이나
        // NullPointerException을 던질 수 있다.
        list.addAll(5, null);
    }
}
