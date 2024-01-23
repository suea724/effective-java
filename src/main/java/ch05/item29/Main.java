package ch05.item29;

public class Main {
    public static void main(String[] args) {
        // 제네릭 Stack을 사용하는 맛보기 프로그램
        StackV3<String> stack = new StackV3<>();
        for (String arg : args) {
            stack.push(arg);
        }
        while (!stack.isEmpty()) {
            // 스택에서 String의 메서드를 호출할 때 명시적 형변환을 수행하지 않으며, 항상 성공함을 보장한다.
            System.out.println(stack.pop().toUpperCase());
        }

    }
}
