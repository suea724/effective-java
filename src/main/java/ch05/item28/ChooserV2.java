package ch05.item28;

import java.util.Collection;

// 제네릭 적용
public class ChooserV2<T> {
    private final T[] choiceArray;

    public ChooserV2(Collection<T> choices) {
        choiceArray = (T[]) choices.toArray(); // T가 무슨 타입인지 알수 없으니 런타임에도 안전한지 보장할 수 없다.
    }
}
