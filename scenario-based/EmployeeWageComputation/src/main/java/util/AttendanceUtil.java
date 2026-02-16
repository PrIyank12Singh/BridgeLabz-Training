package util;

import java.util.Random;

public class AttendanceUtil {

    private static final int IS_ABSENT = 0;
    private static final int IS_FULL_TIME = 1;
    private static final int IS_PART_TIME = 2;

    private static final int FULL_TIME_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;

    private static final Random random = new Random();

    public static int getWorkingHours() {

        int attendance = random.nextInt(3);

        switch (attendance) {

            case IS_FULL_TIME:
                return FULL_TIME_HOURS;

            case IS_PART_TIME:
                return PART_TIME_HOURS;

            default:
                return 0;
        }
    }
}
