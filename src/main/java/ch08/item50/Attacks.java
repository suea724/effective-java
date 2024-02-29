package ch08.item50;

import java.util.Date;

public class Attacks {
    public static void main(String[] args) {
        // 방어적 복사본을 생성하지 않는 인스턴스의 내부 수정 - (1)
        Date start = new Date();
        Date end = new Date();
        PeriodV1 p1 = new PeriodV1(start, end);
        end.setYear(78);
        System.out.println(p1);

        // 방어적 복사본을 생성하지 않는 인스턴스의 내부 수정 - (2)
        start = new Date();
        end = new Date();
        PeriodV1 p2 = new PeriodV1(start, end);
        p2.end().setYear(78);
        System.out.println(p2);

        // 방어적 복사본을 생성하는 인스턴스의 내부 수정 - (1)
        start = new Date();
        end = new Date();
        PeriodV2 p3 = new PeriodV2(start, end);
        end.setYear(78);
        System.out.println(p3);

        // 방어적 복사본을 생성하는 인스턴스의 내부 수정 - (2)
        start = new Date();
        end = new Date();
        PeriodV2 p4 = new PeriodV2(start, end);
        p4.end().setYear(78);
        System.out.println(p4);
    }
}
