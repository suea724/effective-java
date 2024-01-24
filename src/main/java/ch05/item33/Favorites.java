package ch05.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// 타입 안전 이종 컨테이너 패턴
public class Favorites {
    // 타입 안전 이종 컨테이너 패턴 - 구현
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavoritesV1(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    // 동적 형변환으로 런타임 타입 안전성 확보
    public <T> void putFavoritesV2(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
