import java.util.HashMap;

public class CountSubarraysSumK {

    public static int countSubarraysWithSumK(int[] arr, int K) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

       // to handle subarrays starting from index 0
        map.put(0, 1);

        for (int j = 0; j < arr.length; j++) {

            sum += arr[j];

            // Check if (sum - K) exists
            if (map.containsKey(sum - K)) {
                count += map.get(sum - K);
            }

            // Store/update prefix sum count
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {10, 2, -2, -20, 10};
        int K = -10;

        System.out.println("Number of subarrays with sum " + K + " = "
                + countSubarraysWithSumK(arr, K));
    }
}
