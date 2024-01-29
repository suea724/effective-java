package ch06.item39;

import java.lang.annotation.*;

/**
 * 반복 가능한 애너테이션 타입
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class) // 컨테이너 애너테이션 객체를 매개변수로 전달
public @interface ExceptionTestRepeatable {
    Class<? extends Throwable> value();
}
