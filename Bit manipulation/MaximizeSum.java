import java.util.*;

public class MaximizeSum {

    public static int maxSum(List<Integer> nums, int k) {

        int MOD = 1_000_000_007;
        int[] bits = new int[32];
        long ans = 0;

        for (int i = 0; i < nums.size(); i++) {

            int num = nums.get(i);

            for (int j = 0; j < 32; j++) {
                int bit = num & (1 << j);

                if (bit != 0) {
                    bits[j]++;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            long digit = 0;

            for (int j = 0; j < 32; j++) {

                if (bits[j] >= 1) {
                    long bit = 1L << j;
                    digit = digit | bit;
                    bits[j]--;
                }
            }

            long num = digit * digit;
            ans = (ans + num) % MOD;
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