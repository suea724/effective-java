package ch02.item08;

/**
 * cleaner 안전망을 갖춘 자원을 활용하지 못하는 클라이언트
 */
public class Teenager {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("teenager");

        // 가비지 컬렉터 강제 호출 > 이런 방식에 의존하면 안됨!
        //  System.gc();
    }
}
