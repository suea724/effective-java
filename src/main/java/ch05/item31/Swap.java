package ch05.item31;

import java.util.List;

// 명시한 두 인덱스의 아이템들을 교환하는 정적 메서드
public class Swap<E> {

    public static <E> void swapV1(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    // public API로 사용하기에는 간단한 V2가 좋다.
    public static void swapV2(List<?> list, int i, int j) {
        // list.set(i, list.set(j, list.get(i)); // List<?>에는 null 외에 값을 넣을 수 없으므로 컴파일 오류가 발생한다.
        // helper 메서드 사용
        swapHelper(list, i, j);
    }

    // 와일드카드 타입의 실제 타입을 알려주는 헬퍼 메서드 > swapV1이랑 메서드 선언부가 똑같다!
    // 리스트가 List<E>임을 알고 있으므로 컴파일 에러가 발생하지 않는다.
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}
