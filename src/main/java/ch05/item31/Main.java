package ch05.item31;

import java.util.ArrayList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Integer는 Number의 하위 타입이므로 컴파일 성공
        Chooser<Number> chooser = new Chooser<>(new ArrayList<Integer>());

        Set<Integer> integers = Set.of(1, 3, 5);
        Set<Double> doubles = Set.of(2.0, 4.0, 6.0);
        Set<Number> numbers = Union.unionV2(integers, doubles);
    }
}
