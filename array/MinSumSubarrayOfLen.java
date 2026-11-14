import java.util.*;

public class MinSumSubarrayOfLen {

    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int ans = Integer.MAX_VALUE;
        boolean flag = false;

        for (int i = 0; i < nums.size(); i++) {

            int sum = 0;

            for (int j = i; j < nums.size(); j++) {

                sum += nums.get(j);

                int len = j - i + 1;

                if (len >= l && len <= r && sum > 0) {
                    flag = true;
                    ans = Math.min(ans, sum);
                }

                if (len > r) {
                    break;
                }
            }
        }

        if (flag) {
            return ans;
        }

        return -1;
    }

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(3, -2, 1, 4);

        int l = 2;
        int r = 3;

        int result = minimumSumSubarray(nums, l, r);
        System.out.println("Minimum Positive Sum: " + result);

    }
}
