package ch06.item39;

import java.lang.reflect.Method;

/**
 * @Exception 배열 매개변수를 받는 애너테이션을 처리하는 프로그램
 */
public class RunTestsV3 {
    public static void main(String[] args) throws Exception {
        // 배열 매개변수를 받는 애너테이션을 처리하는 코드
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("ch06.item39.SampleV3");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTestArray.class)) {
                tests ++;
                try {
                    m.invoke(null);
                    System.out.printf("테스트 %s 실패: 예외를 던지지 않음%n", m);
                } catch (Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    Class<? extends Throwable>[] excTypes = m.getAnnotation(ExceptionTestArray.class).value();

                    for (Class<? extends Throwable> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) {
                        System.out.printf("테스트 %s 실패: %s %n", m, exc);
                    }
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
