package ch05.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

// 배열을 사용한 코드를 제네릭으로 만드는 방법 1
public class StackV2<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 배열 elements는 push(E)로 넘어온 E 인스턴스만 담는다.
    // 따라서 type 안정성을 보장하지만, 이 배열의 런타임 타입은 E[]가 아닌 Object[]다.
    @SuppressWarnings("unchecked")
    public StackV2() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
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

