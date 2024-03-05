package ch09.item61;

import java.util.Comparator;

public class BrokenComparator {
    public static void main(String[] args) {

        // 겉보기엔 문제가 없어 보이지만 같은 값을 가진 Integer 객체를 다르다고 인식한다.
        Comparator<Integer> naturalOrderV1 =
                (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        System.out.println(naturalOrderV1.compare(new Integer(42), new Integer(42)));

        // 수정한
        Comparator<Integer> naturalOrderV2 = (iBoxed, jBoxed) -> {
          int i = iBoxed, j = jBoxed; // 오토 박싱
          return i < j ? -1 : (i == j ? 0 : 1);
        };
        System.out.println(naturalOrderV2.compare(new Integer(42), new Integer(42)));
    }
}
