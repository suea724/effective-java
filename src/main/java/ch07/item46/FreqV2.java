package ch07.item46;

import ch07.item42.Operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * 스트림을 제대로 활용하여 빈도표를 초기화한다.
 */
public class FreqV2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        Map<String, Long> freq;

         try (Stream<String> words = new Scanner(file).tokens()) {
             // 스트림 패러다임을 제대로 활용했으며 짧고 명확하다.
             freq = words
                     .collect(groupingBy(String::toLowerCase, counting()));
         }

        System.out.println(freq);

         // 빈도표에서 가장 흔한 단어 10개를 뽑아내는 파이프라인
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed()) // 빈도 역순으로 정렬
                .limit(10)
                .collect(toList()); // Collectors 정적 임포트하여 사용하면 가독성이 좋아진다.

        System.out.println(topTen);
    }
}
