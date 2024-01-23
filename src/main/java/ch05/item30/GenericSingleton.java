package ch05.item30;

import java.util.function.UnaryOperator;

// 제네릭 싱글턴 패턴
public class GenericSingleton {
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    // 항등함수는 입력값을 수정없이 그대로 반환하는 함수이므로 타입 안전하다!
    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }
}
