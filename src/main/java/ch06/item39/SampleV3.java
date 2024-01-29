package ch06.item39;

import java.util.ArrayList;
import java.util.List;

/**
 * 배열 매개변수를 받는 애너테이션을 사용하는 프로그램
 */
public class SampleV3 {
    // 원소 하나짜리 매개변수를 받는 애너테이션도 처리할 수 있다.
    @ExceptionTestArray(ArithmeticException.class)
    public static void m1() {  // 성공해야 한다.
        int i = 0;
        i = i / i;
    }

    @ExceptionTestArray(ArithmeticException.class)
    public static void m2() {  // 실패해야 한다. (다른 예외 발생)
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTestArray(ArithmeticException.class)
    public static void m3() { }  // 실패해야 한다. (예외가 발생하지 않음)

    // 배열 매개변수를 받는 애너테이션을 사용
    @ExceptionTestArray({IndexOutOfBoundsException.class, NullPointerException.class})
    public static void m4() {
        List<String> list = new ArrayList<>();

        // 자바 API 명세에 따르면 다음 메서드는 IndexOutOfBoundsException이나 NullPointerException을 던질 수 있다.
        list.addAll(5, null);
    }
}
