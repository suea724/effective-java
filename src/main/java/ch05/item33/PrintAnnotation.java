package ch05.item33;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

// asSubclass를 사용해 한정적 타입토큰을 안전하게 형변환한다.
public class PrintAnnotation {
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType = null; // 비한정적 타입 토큰
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }
}
