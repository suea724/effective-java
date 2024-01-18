package ch02.item03;

/**
 * 싱글톤 객체 - 정적 팩터리 메서드를 public static 멤버로 제공
 */
public class ElvisV2 {
    private static final ElvisV2 INSTANCE = new ElvisV2();
    private ElvisV2() {}

    // 항상 같은 객체의 참조만을 반환한다.
    public static ElvisV2 getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("static factory method");
    }
}
