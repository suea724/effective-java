package ch05.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

// 배열을 사용한 코드를 제네릭으로 만드는 방법 2
public class StackV3<E> {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackV3() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 비검사 경고를 적절히 숨긴다.
    public E pop() {
        if (size == 0)
            throw new EmptyStackException();

        // push에서 E 타입만 허용하므로 이 형변환은 안전하다.
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];

        elements[size] = null; // 다 쓴 참조 해제해주어야 함!
        return result;
    }

    // 원소를 위한 공간을 적어도 하나 이상 확보한다.
    // 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }
}

