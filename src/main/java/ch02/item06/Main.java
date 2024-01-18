package ch02.item06;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        // Pattern 인스턴스를 계속 생성하는 ver.
        long start = System.currentTimeMillis();
        for (int i = 0 ; i < 100 ; i ++) {
            RomanNumerals.isRomanNumeralSlow("abcdefgh");
        }
        long end = System.currentTimeMillis();
        log.info("isRomanNumeralSlow = {}", end-start); // 약 10 ~ 15ns 소요

        // 한번 생성한 Pattern 인스턴스를 재활용하는 ver.
        start = System.currentTimeMillis();
        for (int i = 0 ; i < 100 ; i ++) {
            RomanNumerals.isRomanNumeralFast("abcdefgh");
        }
        end = System.currentTimeMillis();
        log.info("isRomanNumeralFast = {}", end-start); // 약 0 ~ 1ns 소요

        // 오토박싱 O
        start = System.currentTimeMillis();
        Sum.sumSlow();
        end = System.currentTimeMillis();
        log.info("sumSlow = {}", end-start); // 약 7000 ns 소요

        // 오토박싱 X
        start = System.currentTimeMillis();
        Sum.sumFast();
        end = System.currentTimeMillis();
        log.info("sumFast = {}", end-start); // 약 850 ns 소요
    }
}
