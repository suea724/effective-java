package ch02.item02;

import lombok.extern.slf4j.Slf4j;

import static ch02.item02.Pizza.Topping.*;

@Slf4j
public class Main {
    public static void main(String[] args) {

        // 점층적 생성자 패턴 - 각 매개변수 값을 알기 어렵다.
        NutritionFactsV1 cocaCola1 = new NutritionFactsV1(240, 8, 100, 0, 35, 27);

        // 자바 빈즈 - 세터 메서드를 모두 호출하기 전에는 일관성이 깨진다. 값 주입 중에 다른 메서드가 실행된다면?
        NutritionFactsV2 cocaCola2 = new NutritionFactsV2();
        cocaCola2.setFat(0);
        cocaCola2.setCarbohydrate(27);
        cocaCola2.setSodium(35);
        cocaCola2.setServings(8);
        cocaCola2.setServingSize(240);

        // 빌더 - 안정성+가독성
        NutritionFactsV3 cocaCola3 = new NutritionFactsV3.Builder(240, 8)
                                                            .calories(100)
                                                            .sodium(35)
                                                            .carbohydrate(27).build();

        // 계층적 빌더
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                                        .addTopping(SAUSAGE)
                                        .addTopping(ONION)
                                        .build();

        Calzone calzone = new Calzone.Builder()
                                        .addTopping(HAM)
                                        .sauceInside()
                                        .build();

        log.info("nyPizza = {}", nyPizza);
        log.info("calzone = {}", calzone);
    }
}
