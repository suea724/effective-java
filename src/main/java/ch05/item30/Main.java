package ch05.item30;

import java.util.Set;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        // 제네릭 메서드 활용 예시
        Set<String> guys = Set.of("톰", "딕", "해리");
        Set<String> stooges = Set.of("래리", "모에", "컬리");
        Set<String> aflCio = Union.unionV2(guys, stooges);
        System.out.println(aflCio); // [톰, 해리, 래리, 딕, 컬리, 모에]
        
        // 제네릭 싱글턴 활용 예
        String[] strings = {"삼베", "대마", "나일론"};
        UnaryOperator<String> sameString = GenericSingleton.identityFunction();
        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = {1, 2.0, 3L};
        UnaryOperator<Number> sameNumber = GenericSingleton.identityFunction();
        for (Number n : numbers) {
            System.out.println(sameNumber.apply(n));
        }
    }
}
