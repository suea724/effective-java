package ch07.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 스트림 패러다임을 이해하지 못한 채 API만 사용한 예 - 따라하지 말 것!
 */
public class FreqV1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);

        Map<String, Long> freq = new HashMap<>();
        try (Stream<String> words = new Scanner(file).tokens()) {
            // 스트림을 가장한 반복 코드! (길고, 읽기 어렵고, 유지보수에 좋지 않음)
            // forEach는 스트림 계산 결과를 보고할 때만 사용해야 함.
            words.forEach(word -> {
                freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
        }
    }
}
