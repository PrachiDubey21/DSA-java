import java.util.*;

public class SplitArrayLargestSum {

    public static boolean isPossible(int[] arr, int k, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (currentSum + arr[i] <= maxSum) {
                currentSum += arr[i];
            } else {
                subarrays++;
                currentSum = arr[i];
            }
        }
        return subarrays <= k;
    }

    public static int splitArray(int[] arr, int k) {
        int low = 0, high = 0;

        // Define search space
        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }

        int answer = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(arr, k, mid)) {
                answer = mid;
                high = mid - 1; // try smaller max sum
            } else {
                low = mid + 1; // increase max sum
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int k = 4;

        System.out.println(splitArray(arr, k));
    }
}
