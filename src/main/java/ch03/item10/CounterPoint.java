package ch03.item10;

import java.util.concurrent.atomic.AtomicInteger;

// Point의 하위 클래스 - 값 컴포넌트를 추가하지 않음.
public class CounterPoint extends Point {
    private static final AtomicInteger counter =
            new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }
    public static int numberCreated() { return counter.get(); }
}
