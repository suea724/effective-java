package ch02.item02;

import lombok.Builder;
import lombok.ToString;

/**
 * 롬복 @Builder 사용
 *  - builderMethod 재정의
 */
@Builder(builderMethodName = "innerBuilder") // 기존 빌더 메서드명을 innerBuilder로 변경
@ToString
public class NutritionFactsLombokV1 {
    private final int servingSize; // 필수
    private final int servings; // 필수
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    // builder 메서드를 재정의해서 필수 필드를 입력받도록 변경
    public static NutritionFactsLombokV1Builder builder(int servingSize, int servings) {
        return innerBuilder()
                .servingSize(servingSize)
                .servings(servings);
    }
}
