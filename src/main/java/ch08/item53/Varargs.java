package ch08.item53;

/**
 * 가변인수 활용 예
 */
public class Varargs {
    
    // 간단한 가변인수 활용 예
    static int sum(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    // 인수 1개 이상이어야 하는 가변 인수 메서드 - 잘못 구현
    static int minV1(int... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("인수 1개 이상 필요");
        }
        int min = args[0];
        for (int i = 0 ; i < args.length ; i ++) {
            if (min > args[i]) {
                min = args[i];
            }
        }
        return min;

//        for (int arg :
//                args) {
//            if (min > arg)
//                min = arg;
//        }
    }

    // 인수 1개 이상이어야 하는 가변 인수 메서드 - 제대로 구현
    static int minV2(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs) {
            if (min > arg)
                min = arg;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minV1(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(minV2(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        // System.out.println(minV2()); // 컴파일 오류 발생!
    }
}
