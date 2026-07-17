import java.util.*;

public class OverlappingAttack {

    public static int findDuration(int[] timeSeries, int duration) {

        if (timeSeries.length == 0) {
            return 0;
        }

        int total = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {

            int gap = timeSeries[i + 1] - timeSeries[i];

            if (gap >= duration) {
                total += duration;
            } else {
                total += gap;
            }
        }

        total += duration;

        return total;
    }

    public static void main(String[] args) {

        int[] timeSeries = {1, 2};
        int duration = 2;

        int result = findDuration(timeSeries, duration);
        System.out.println("Total Poisoned Duration = " + result);
    
    }
   
}
