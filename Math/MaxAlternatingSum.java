import java.util.*;

public class MaxAlternatingSum {

    public static long maxAlternatingSum(int[] nums) {

        long ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        int m = n / 2;

        for (int i = 0; i < m; i++) {
            ans = ans - nums[i];
        }

        for (int i = m; i < n; i++) {
            ans = ans + nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3 };

        long result = maxAlternatingSum(nums);

        System.out.println(result);
    }

}