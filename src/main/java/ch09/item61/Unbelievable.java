package ch09.item61;

public class Unbelievable {
    static Integer i;

    public static void main(String[] args) {
        // NPE 발생!
        if (i == 42) {
            System.out.println("Unbelievable");
        }
    }
}
