package ch07.item47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

// Stream <-> Iterator 어댑터
public class Adapters {

    // Stream<E> -> Iterator<E> 어댑터
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    // Iterable<E> → Stream<E> 어댑터
    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
