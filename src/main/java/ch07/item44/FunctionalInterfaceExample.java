package ch07.item44;

import java.time.Instant;
import java.util.function.*;

// java.util.function 함수형 인터페이스 기본 6개 간단 예제
public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // UnaryOperator
        System.out.println("[UnaryOperator]");
        UnaryOperator<Integer> plus10 = i -> i + 10;
        UnaryOperator<Integer> multiply2 = i -> i * 2;
        System.out.println(plus10.andThen(multiply2).apply(10)); // (10 + 10) * 2

        // BinaryOperator
        System.out.println("[BinaryOperator]");
        BinaryOperator<Integer> sum = (a,b) -> a+b;
        System.out.println(sum.apply(10, 20)); // 10 + 20

        // Predicate
        System.out.println("[Predicate]");
        Predicate<Integer> isLargerThan100 = i -> i > 100;
        System.out.println(isLargerThan100.test(10)); // false
        System.out.println(isLargerThan100.test(1000)); // true

        Predicate<String> containsHello = s -> s.contains("hello");
        System.out.println(containsHello.test("olleh")); // false
        System.out.println(containsHello.test("hello")); // true

        // Function
        System.out.println("[Function]");
        Function<String, Integer> findIndexOfA = s -> s.indexOf("a");
        System.out.println(findIndexOfA.apply("banana"));

        // Supplier
        System.out.println("[Supplier]");
        Supplier<Instant> getNow = () -> Instant.now();
        System.out.println(getNow.get());

        // Consumer
        System.out.println("[Consumer]");
        Consumer<String> printStr = s -> System.out.println(s);
        printStr.accept("mango");
    }
}
