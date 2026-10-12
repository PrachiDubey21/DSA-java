import java.util.*;

public class MaximizeSum {

    public static int maxSum(List<Integer> nums, int k) {

        int MOD = 1_000_000_007;
        int[] bits = new int[32];

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bits[i]++;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int j = 0; j < 32; j++) {
                if (bits[j] > 0) {
                    num |= (1L << j);
                    bits[j]--;
                }
            }

            ans = (ans + num * num) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(2, 6, 5);
        int k = 2;

        int result = maxSum(nums, k);
        System.out.println("Maximum sum of squares: " + result);
        
    }
}