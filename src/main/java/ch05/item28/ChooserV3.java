package ch05.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// 제네릭, 배열 대신 리스트 사용
public class ChooserV3<T> {
    private final List<T> choiceList;

    public ChooserV3(Collection<T> choices) {
        choiceList = new ArrayList<>(choices); // 비검사 형변환 경고 제거됨.
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
