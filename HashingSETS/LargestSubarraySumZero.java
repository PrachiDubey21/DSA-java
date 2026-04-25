import java.util.HashMap;

public class LargestSubarraySumZero {

    public static int largestSubarrayWithZeroSum(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            if (prefixSum == 0) {
                maxLen = i + 1;
            }

            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } 
            else {
                map.put(prefixSum, i);
            }
            
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        System.out.println("Length of largest subarray with sum 0: "
                + largestSubarrayWithZeroSum(arr));
    }
}
