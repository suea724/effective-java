package ch07.item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

// 함수 객체로 정렬하기
public class SortString {
    // 익명 클래스 적용 - 구식
    public static void sortV1(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println("sortV1 list = " + list);
    }
    
    // 람다 적용
    public static void sortV2(List<String> list) {
        Collections.sort(list, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("sortV2 list = " + list);
    }

    // 비교자 생성 메서드 사용 (스트림)
    public static void sortV3(List<String> list) {
        Collections.sort(list, comparingInt(String::length));
        System.out.println("sortV3 list = " + list);
    }

    // List 인터페이스의 sort 메서드 사용
    public static void sortV4(List<String> list) {
        list.sort(comparingInt(String::length));
        System.out.println("sortV4 list = " + list);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "aaa", "aaaa", "aaaaa");
        Collections.shuffle(list);
        sortV1(list);

        Collections.shuffle(list);
        sortV2(list);

        Collections.shuffle(list);
        sortV3(list);

        Collections.shuffle(list);
        sortV4(list);
    }

}
