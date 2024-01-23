package ch05.item30;

import java.util.HashSet;
import java.util.Set;

public class Union {
    // 로 타입 사용 - 경고 발생
    public static Set unionV1(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    // 제네릭 메서드로 변환
    public static <E> Set<E> unionV2(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}
