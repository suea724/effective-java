package ch05.item32;

import java.util.ArrayList;
import java.util.List;

public class Flatten {

    // 제네릭 varargs 매개변수를 안전하게 사용하는 메서드
    @SafeVarargs
    static <T> List<T> flattenV1(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    // 제네릭 varargs 매개변수를 List로 대체 - 타입 안전하다.
    static <T> List<T> flattenV2(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }
}
