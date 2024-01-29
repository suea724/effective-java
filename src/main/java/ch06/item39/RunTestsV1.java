package ch06.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Test 마커 애너테이션을 처리하는 프로그램
 */
public class RunTestsV1 {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("ch06.item39.SampleV1");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests ++;
                try {
                    m.invoke(null);
                    passed ++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " 실패: " + exc);
                } catch (Exception exc) {
                    System.out.println("잘못 사용한 @Test: " + m);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
