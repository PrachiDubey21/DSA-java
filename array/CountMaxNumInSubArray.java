import java.util.*;

public class CountMaxNumInSubArray {

    public static int countSubarrays(int[] nums, int k) {

        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = i; j < n; j++) {

                if (nums[j] == k) {
                    count++;
                }

                int length = j - i + 1;

                if (2 * count > length) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 2, 3 };
        int k = 2;

        System.out.println(countSubarrays(nums, k));
    }

}
