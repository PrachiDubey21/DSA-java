import java.util.*;

public class MinTimeForWaterAndLandRides {

    public static int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < landStartTime.length; i++) {

            int landFinish = landStartTime[i] + landDuration[i];

            for(int j = 0; j < waterStartTime.length; j++) {

                int waterStart =
                    Math.max(landFinish, waterStartTime[j]);

                int finalFinish =
                    waterStart + waterDuration[j];

                ans = Math.min(ans, finalFinish);
            }
        }

        // Water -> Land
        for(int i = 0; i < waterStartTime.length; i++) {

            int waterFinish =
                waterStartTime[i] + waterDuration[i];

            for(int j = 0; j < landStartTime.length; j++) {

                int landStart =
                    Math.max(waterFinish, landStartTime[j]);

                int finalFinish =
                    landStart + landDuration[j];

                ans = Math.min(ans, finalFinish);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};

        int[] waterStartTime = {6};
        int[] waterDuration = {3};

        int result = earliestFinishTime(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration);

        System.out.println(result);
    }

    
}
