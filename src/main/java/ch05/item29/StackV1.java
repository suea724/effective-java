package ch05.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackV1<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 실체화 불가 타입으로는 배열을 만들 수 없다. (컴파일 X)
    public StackV1() {
        // elements = new E[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
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
}

