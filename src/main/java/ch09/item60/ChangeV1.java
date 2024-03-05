package ch09.item60;

/**
 * 금융 계산에 부동소수 타입을 사용하여 부정확한 값 도출
 */
public class ChangeV1 {
    public static void main(String[] args) {
        double funds = 1.00;
        int itemsBought = 0;

        for (double price = 0.10 ; funds >= price ; price += 0.10) {
            funds -= price;
            itemsBought ++;
        }

        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈 : " + funds);
    }
}
