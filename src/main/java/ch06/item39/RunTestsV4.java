package ch06.item39;

import java.lang.reflect.Method;

/**
 * 반복 가능 애너테이션을 처리하는 프로그램
 */
public class RunTestsV4 {
    public static void main(String[] args) throws Exception {
        // 코드 39-10 반복 가능 애너테이션 다루기 (244-245쪽)
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName("ch06.item39.SampleV4");

        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTestRepeatable.class)
                    || m.isAnnotationPresent(ExceptionTestContainer.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("테스트 %s 실패: 예외를 던지지 않음%n", m);
                } catch (Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    ExceptionTestRepeatable[] excTests =
                            m.getAnnotationsByType(ExceptionTestRepeatable.class);
                    for (ExceptionTestRepeatable excTest : excTests) {
                        if (excTest.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed)
                        System.out.printf("테스트 %s 실패: %s %n", m, exc);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n",
                passed, tests - passed);
    }
}
