package ch05.item33;

import static ch05.item33.PrintAnnotation.getAnnotation;

public class Main {
    public static void main(String[] args) throws Exception {
        // 타입 안전 이종 컨테이너 패턴 - 클라이언트
        Favorites f = new Favorites();

        f.putFavoritesV1(String.class, "Java");
        f.putFavoritesV1(Integer.class, 0xcafebabe);
        f.putFavoritesV1(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);

        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
        
        // 명시한 클래스의 명시한애노테이션을 출력하는 테스트 프로그램
        if (args.length != 2) {
            System.out.println(
                    "사용법: java PrintAnnotation <class> <annotation>");
            System.exit(1);
        }
        String className = args[0];
        String annotationTypeName = args[1];
        Class<?> klass = Class.forName(className);
        System.out.println(getAnnotation(klass, annotationTypeName));
    }
}
