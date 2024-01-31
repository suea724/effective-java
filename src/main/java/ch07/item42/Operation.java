package ch07.item42;

import java.util.function.DoubleBinaryOperator;

// 열거 타입 상수별 메서드에 람다식 적용
public enum Operation {
    PLUS ("+", (x,y) -> x + y),
    MINUS ("-", (x,y) -> x - y),
    TIMES ("*", (x,y) -> x * y),
    DIVIDE ("/", (x,y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op; // 자바 유틸 패키지에서 제공하는 함수 인터페이스로, double 타입 인수 2개를 받아 결과를 돌려줌.

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
