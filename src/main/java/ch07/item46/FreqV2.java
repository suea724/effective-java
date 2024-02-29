package ch07.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

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
    }
}
