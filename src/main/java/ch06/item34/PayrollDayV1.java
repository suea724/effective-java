package ch06.item34;

// 값에 따라 분기하여 코드를 공유하는 열거타입
public enum PayrollDayV1 {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int MINS_PER_SHIFT = 8 * 60;

    int pay(int minutesWorked, int payRate) {
        int basePay = minutesWorked * payRate;

        int overtimePay;
        switch (this) {
            // 주말
            case SATURDAY:
            case SUNDAY:
                overtimePay = basePay / 2;
                break;
            // 주중
            default :
                overtimePay = minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        }

        return basePay + overtimePay;
    }
}
