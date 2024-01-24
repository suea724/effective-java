package ch05.item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {
    private final List<T> choiceList;

    // choices 컬렉션은 T값을 생산하기만 하니 extends 와일드카드 타입 적용
    public Chooser(Collection<? extends T> choices) {
        choiceList = new ArrayList<>(choices); // 비검사 형변환 경고 제거됨.
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
