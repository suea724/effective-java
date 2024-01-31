package ch07.item43;

import java.util.Map;
import java.util.TreeMap;

// map.merge를 이용해 구현한 빈도표
public class Freq {
    public static void main(String[] args) {
        Map<String, Integer> frequencyTable = new TreeMap<>();

        for (String s : args) {
            frequencyTable.merge(s, 1, (count, incr) -> count + incr); // 람다
        }
        System.out.println(frequencyTable);

        frequencyTable.clear();
        for (String s : args) {
            frequencyTable.merge(s, 1, Integer::sum); // 메서드 참조
        }
        System.out.println(frequencyTable);
    }
}
