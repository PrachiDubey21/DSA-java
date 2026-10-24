import java.util.*;

public class CountDaysSpentTogether {

    public static int countDaysTogether(String arriveAlice, String leaveAlice,
            String arriveBob, String leaveBob) {

        int a = getDays(arriveAlice);
        int b = getDays(leaveAlice);
        int c = getDays(arriveBob);
        int d = getDays(leaveBob);

        int start = Math.max(a, c);
        int end = Math.min(b, d);

        if (start > end) {
            return 0;
        }

        return end - start + 1;
    }

    public static int getDays(String date) {
        int[] days = { 31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31 };

        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));

        for (int i = 0; i < month - 1; i++) {
            day += days[i];
        }

        return day;
    }

    public static void main(String[] args) {

        String arriveAlice = "08-15";
        String leaveAlice = "08-18";
        String arriveBob = "08-16";
        String leaveBob = "08-19";

        int result = countDaysTogether(
                arriveAlice, leaveAlice, arriveBob, leaveBob);

        System.out.println(result);
    }

}