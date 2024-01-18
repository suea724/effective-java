package ch02.item03;

/**
 * 싱글톤 객체 - ENUM 타입 선언 (가장 바람직)
 */
public enum ElvisV3 {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("ENUM");
    }
}
