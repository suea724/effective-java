package ch05.item32;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 제네릭 매개변수에 값을 저장하는 것은 안전하지 않다.
        // Dangerous.dangerous(List.of("dangerous")); // ClassCastException

        // 제네릭 varargs배열을 사용하는 pickTwo - 안전하지 않다.
        // String[] attributes1 = PickTwo.pickTwoV1("좋은", "빠른", "저렴한"); // ClassCastException

        // 배열 대신 List를 사용하는 pickTwo - 안전하다.
        List<String> attributes2 = PickTwo.pickTwoV2("좋은", "빠른", "저렴한");
        System.out.println("attributes2 = " + attributes2);

        // 제네릭 varargs 매개변수를 안전하게 사용
        List<Integer> flatList1 = Flatten.flattenV1(List.of(1, 2), List.of(3, 4, 5), List.of(6, 4));
        System.out.println("flatList1 = " + flatList1);

        // 제네릭 varargs 매개변수를 List로 대체
        List<Integer> flatList2 = Flatten.flattenV2(List.of(List.of(1, 2), List.of(3, 4, 5), List.of(6, 4)));
        System.out.println("flatList2 = " + flatList2);
    }
}
