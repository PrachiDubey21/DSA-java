import java.util.*;

public class MinTimeToFillSlots {

    public static int minTime(int N, int[] arr) {

        Arrays.sort(arr);

        int maxTime = 0;

        // Left side
        maxTime = Math.max(maxTime, arr[0] - 1);

        // Right side
        maxTime = Math.max(maxTime, N - arr[arr.length - 1]);

        // Middle gaps
        for (int i = 1; i < arr.length; i++) {
            int gap = (arr[i] - arr[i - 1]) / 2;
            maxTime = Math.max(maxTime, gap);
        }

        return maxTime;
    }

    public static void main(String[] args) {

        int N = 6;
        int[] arr = {2, 6};

        System.out.println("Minimum Time: " + minTime(N, arr));
    }

    
}
