package ch02.item02;

import lombok.Builder;
import lombok.NonNull;

/**
 * 롬복 @Builder 사용
 *  - 필수값에 @NonNull 애노테이션 사용
 */
@Builder
public class NutritionFactsLombokV2 {

    @NonNull
    private Integer servingSize; // 필수

    @NonNull
    private Integer servings; // 필수
    
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;
}
