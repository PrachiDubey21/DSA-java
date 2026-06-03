import java.util.*;

public class MinTimeForWaterAndLandRide2 {

    public static int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {

        int x = calc(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration);

        int y = calc(
                waterStartTime,
                waterDuration,
                landStartTime,
                landDuration);

        return Math.min(x, y);
    }

    public static int calc(
            int[] start1,
            int[] dur1,
            int[] start2,
            int[] dur2) {

        int minEnd = Integer.MAX_VALUE;

        for (int i = 0; i < start1.length; i++) {

            minEnd = Math.min(
                    minEnd,
                    start1[i] + dur1[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < start2.length; i++) {

            int finish = Math.max(minEnd, start2[i]) + dur2[i];

            ans = Math.min(ans, finish);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] landStartTime = { 2, 8 };
        int[] landDuration = { 4, 1 };

        int[] waterStartTime = { 6, 10 };
        int[] waterDuration = { 3, 2 };

        int result = earliestFinishTime(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration);

        System.out.println("Earliest Finish Time = " + result);
    }

}
