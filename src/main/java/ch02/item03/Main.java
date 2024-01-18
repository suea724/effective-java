package ch02.item03;

public class Main {
    public static void main(String[] args) {
        /* 싱글톤 객체 테스트 => 각각 같은 참조값 및 해시코드 반환 */

        // public static final 필드
        System.out.println(ElvisV1.INSTANCE);
        System.out.println(ElvisV1.INSTANCE);

        // 정적 팩토리 메서드
        System.out.println(ElvisV2.getInstance());
        System.out.println(ElvisV2.getInstance());

        // enum
        System.out.println(ElvisV3.INSTANCE.hashCode());
        System.out.println(ElvisV3.INSTANCE.hashCode());
    }
}
