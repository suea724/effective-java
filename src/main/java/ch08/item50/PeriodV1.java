package ch08.item50;

import java.util.Date;

public class PeriodV1 {
    private final Date start;
    private final Date end;

    /**
     * @param start
     * @param end
     * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 때 발생
     * @throws NullPointerException start나 end가 null이면 발생
     */
    public PeriodV1(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
        }
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }

    @Override
    public String toString() {
        return "Period{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
