package ch06.item38;

import java.util.Arrays;
import java.util.Collection;

public enum ExtendedOperation implements Operation {
    EXP("^") {
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;
    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }
    @Override public String toString() {
        return symbol;
    }

    public static void main(String[] args) {
        double x = 2.0;
        double y = 3.0;
        testV1(ExtendedOperation.class, x, y);
        System.out.println("========================");
        testV2(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    // 열거 타입의 Class 객체를 이용해 확장된 열거 타입의 모든 원소를 사용하는 예
    private static <T extends Enum<T> & Operation> void testV1(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    // 컬렉션 인스턴스를 이용해 확장된 열거 타입의 모든 원소를 사용하는 예
    private static void testV2(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
