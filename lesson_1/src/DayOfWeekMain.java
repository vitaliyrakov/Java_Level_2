public class DayOfWeekMain {

    private static final int WORKING_HOURS_PER_DAY = 8;

    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.TUESDAY));
    }

    private static int getWorkingHours(DayOfWeek day) {
       if (day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY))
            System.out.println("Сегодня выходной");

        int workDay=0;
        for (DayOfWeek d : DayOfWeek.values()) {
            if ((d.equals(day) || workDay>0) && d!= DayOfWeek.SUNDAY && d!=DayOfWeek.SATURDAY)
                workDay++;
        }
        return workDay*WORKING_HOURS_PER_DAY;
    }
}
