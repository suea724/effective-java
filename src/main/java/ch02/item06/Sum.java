package ch02.item06;

public class Sum {
    public static long sumSlow() {
        Long sum = 0L;
        for (long i = 0 ; i <= Integer.MAX_VALUE ; i ++) {
            sum += i; // 오토 박싱 발생!
        }
        return sum;
    }

    public static long sumFast() {
        long sum = 0L;
        for (long i = 0 ; i <= Integer.MAX_VALUE ; i ++) {
            sum += i; // 오토 박싱 발생!
        }
        return sum;
    }
}
