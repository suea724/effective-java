package ch07.item46;

import ch07.item42.Operation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.function.BinaryOperator.*;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class CollectorEx {
    public static void main(String[] args) {

        // toList
        Map<String, Long> freq = new HashMap<>();
        freq.put("apple", 3L);
        freq.put("banana", 4L);
        freq.put("carrot", 5L);

        // 빈도표에서 가장 흔한 단어 10개를 뽑아내는 파이프라인
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed()) // 빈도 역순으로 정렬
                .limit(10)
                .collect(toList()); // Collectors 정적 임포트하여 사용하면 가독성이 좋아진다.
        System.out.println("topTen = " + topTen);

        // 인수가 2개인 toMap
        Map<String, Operation> stringToEnum = Stream.of(Operation.values()).collect(toMap(Object::toString, e -> e));
        System.out.println("stringToEnum = " + stringToEnum);

        // 인수가 3개인 toMap
        Artist artist1 = new Artist("aaa");
        Artist artist2 = new Artist("bbb");
        Artist artist3 = new Artist("ccc");

        Album album1 = new Album(artist1, 3);
        Album album2 = new Album(artist1, 4);
        Album album3 = new Album(artist2, 2);
        Album album4 = new Album(artist3, 10);
        List<Album> albums = List.of(album1, album2, album3, album4);

        Map<Artist, Album> topHits = albums.stream().collect(toMap(Album::artist, a -> a, maxBy(comparing(Album::sales))));
        System.out.println("topHits = " + topHits);

        // 인수를 4개 받는 toMap
        List<String> strings = List.of("apple", "banana", "grape", "grape", "grape", "watermelon");
        LinkedHashMap<Character, String> map = strings.stream().collect(toMap(s -> s.charAt(0), s -> s, (s1, s2) -> s1 + ", " + s2, LinkedHashMap::new));
        System.out.println("map = " + map);


    }
}
