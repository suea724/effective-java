package ch05.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// 제네릭 적용X
public class ChooserV1 {
    private final Object[] choiceArray;

    public ChooserV1(Collection choices) {
        choiceArray = choices.toArray();
    }

    // choose 메서드를 호출할 때마다 반환된 Object를 원하는 타입으로 형변환 해야함.
    // 타입이 다른 원소가 들어있었다면 런타임에 형변환 오류 발생
    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
