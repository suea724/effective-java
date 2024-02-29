package ch08.item52;

import java.util.*;

public class CollectionClassifier {
    public static String classify(Set<?> set) {
        return "집합";
    }

    public static String classify(List<?> list) {
        return "리스트";
    }

    public static String classify(Collection<?> collection) {
        return "그 외";
    }
    
    // 런타임 타입에 기초해 메서드 분배
    public static String classifyV2(Collection<?> collection) {
        // instanceof 메서드로 런타임타입 명시적 검사
        return collection instanceof Set ? "집합" :
                collection instanceof List ? "리스트" :
                "그외";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<>(),
                new ArrayList<>(),
                new HashMap<>().values()
        };

        for (Collection<?> c : collections) {
            System.out.println(classify(c));
        }

        for (Collection<?> c : collections) {
            System.out.println(classifyV2(c));
        }
    }
}
