package ch05.item26;

import java.util.ArrayList;
import java.util.List;

// 런타임에 실패
public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42)); // 컴파일 오류가 나지 않음.
        String s = strings.get(0); // 컴파일러가 자동으로 형변환 코드를 넣어준다. (ClassCastException 발생, Integer -> String)
    }

    // raw type 리스트에 저장 
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
