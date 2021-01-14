public class DayOfWeekMain {

    private static final int WORKING_HOURS_PER_DAY = 8;

    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.TUESDAY));
    }

    private static int getWorkingHours(DayOfWeek day) {
        if (day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY))
            System.out.println("Сегодня выходной");

        for (DayOfWeek d : DayOfWeek.values()) {
            if (day.ordinal() >= d.ordinal() && d!= DayOfWeek.SUNDAY && d!=DayOfWeek.SATURDAY)
                System.out.println(d);
        }
        return 1;
    }
}
