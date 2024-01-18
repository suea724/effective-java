package ch02.item02;

/**
 * 빌더 패턴
 *  - 점층적 생성자 패턴의 안정성 + 자바 빈즈의 가독성
 *  - 필수 매개변수만을 생성자로 호출하고, 선택 매개변수를 설정한다.
 */
public class NutritionFactsV3 {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    // 빌더를 정적 멤버 클래스로 작성
    public static class Builder {
        // 필수 매개변수
        private final int servingSize;
        private final int servings;

        // 선택 매개변수 (기본값으로 초기화)
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        // 필수 매개변수 값을 매개변수로 받는 생성자만 작성
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        // 빌더의 세터 메서드들은 메서드 체이닝을 위해 값을 세팅하고 자기 자신을 반환 
        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFactsV3 build() {
            return new NutritionFactsV3(this);
        }

    }

    // 빌더 객체를 매개변수로 받는 생성자만 작성
    private NutritionFactsV3(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
