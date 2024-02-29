package ch07.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.math.BigInteger.*;

public class MersennePrimes {
    public static void main(String[] args) {
        // 메르센 소수 생성
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);

        long startTime = System.currentTimeMillis();
        pi(1000);
        long endTime = System.currentTimeMillis();
        System.out.println("pi = " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        piParallel(1000);
        endTime = System.currentTimeMillis();
        System.out.println("piParallel = " + (endTime - startTime));
    }

    // n보다 작거나 같은 소수의 개수 계산 - 병렬화 X
    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    // n보다 작거나 같은 소수의 개수 계산 - 병렬화 O
    static long piParallel(long n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
