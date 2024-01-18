package ch02.item04;

/**
 * 인스턴스를 만들 수 없는 유틸리티 클래스
 */
public class UtilityClass {
    // 기본 생성자가 호출되는 것을 막는다. (인스턴스화 방지용)
    // 내부에서 호출되어서도 안된다면 예외를 떨어뜨리자.
    private UtilityClass() {
        throw new AssertionError();
    }
}
