package ch02.item03;

/**
 * 싱글턴 객체 - public static final 필드 사용
 */
public class ElvisV1 {
    public static final ElvisV1 INSTANCE = new ElvisV1();

    // 기본 생성자를 private으로 작성하여 외부에서 호출되지 않음. 객체는 초기화 시 하나만 생성 됨을 보장.
    private ElvisV1() {}

    public void leaveTheBuilding() {
        System.out.println("public static final field");
    }
}
