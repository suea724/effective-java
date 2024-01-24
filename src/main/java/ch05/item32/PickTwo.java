package ch05.item32;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PickTwo {

    // 자신의 제네릭 매개변수 배열의 참조를 노출한다. - 안전하지 않다!
    static <T> T[] toArray(T... args) {
        return args;
    }

    // 미묘한 힙 오염 발생
    static <T> T[] pickTwoV1(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0 :
                return toArray(a, b);
            case 1 :
                return toArray(a, c);
            case 2 :
                return toArray(b, c);
        }
        throw new AssertionError(); // 도달할 수 없다.
    }

    // 배열 대신 List를 사용하여 안전하게 바꿈
    static <T> List<T> pickTwoV2(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0 :
                return List.of(a, b);
            case 1 :
                return List.of(a, c);
            case 2 :
                return List.of(b, c);
        }
        throw new AssertionError();
    }
}
