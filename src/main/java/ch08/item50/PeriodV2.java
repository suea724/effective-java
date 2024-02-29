package ch08.item50;

import java.util.Date;

public class PeriodV2 {
    private final Date start;
    private final Date end;

    /**
     * @param start
     * @param end
     * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 때 발생
     * @throws NullPointerException start나 end가 null이면 발생
     */
    public PeriodV2(Date start, Date end) {
        // 방어적 복사본 생성
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
        }
    }

    // 접근자 메서드를 필드의 방어적 복사본을 만들도록 수정
    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return "Period{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
