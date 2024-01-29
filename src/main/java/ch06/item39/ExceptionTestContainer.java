package ch06.item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 반복 가능한 애너테이션의 컨테이너 애너테이션
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTestContainer {
    ExceptionTestRepeatable[] value(); // 반복 가능 애너테이션 타입의 배열을 반환한다.
}
