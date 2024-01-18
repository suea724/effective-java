package ch02.item08;

/**
 * cleaner 안정망을 갖춘 자원을 제대로 활용하는 클라이언트
 */
public class Adult {
    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("adult"); // 출력 이후
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
