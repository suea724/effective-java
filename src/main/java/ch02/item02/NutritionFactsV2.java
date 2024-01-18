package ch02.item02;

/**
 * 자바빈즈 패턴
 *  - setter 메서드로 매개변수 값 설정
 *  - 일관성이 깨지고, 불변으로 만들 수 없다.
 *  - 코드가 길어진다.
 */
public class NutritionFactsV2 {
    // 매개변수들은 (기본값이 있다면) 기본값으로 초기화 된다.
    private int servingSize = -1; // 필수, 기본값 X
    private int servings = -1; // 필수, 기본값 X
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public NutritionFactsV2() {
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
