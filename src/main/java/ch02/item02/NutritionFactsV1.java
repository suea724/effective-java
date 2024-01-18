package ch02.item02;

/**
 * 점층적 생성자 패턴
 *  - 사용자가 설정하기 원치 않는 매개변수까지 포함할 수 있다.
 *  - 매개변수 개수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다.
 */
public class NutritionFactsV1 {
    private final int servingSize;  // (mL, 1회 제공량) 필수
    private final int servings;     // (회, 총 n회 제공량) 필수
    private final int calories;     // (1회 제공량당) 선택
    private final int fat;          // (g/1회 제공량) 선택
    private final int sodium;       // (mg/1회 제공량) 선택
    private final int carbohydrate; // (g/1회 제공량) 선택

    public NutritionFactsV1(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFactsV1(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFactsV1(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFactsV1(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFactsV1(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
