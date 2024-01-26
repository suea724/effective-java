package ch06.item34;

// 상수별 메서드 구현을 활용한 열거타입
public enum OperationV2 {

    // 각 상수에서 추상 메서드 재정의
    PLUS {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE {
        public double apply(double x, double y) { return x / y; }
    };


    // 상수별로 다르게 동작하는 추상 메서드 선언
    public abstract double apply(double x, double y);
}
