import java.util.*;

public class MinDiffBetweenHighAndLowKScores {

    public static int minimumDifference(int[] nums, int k) {

        if (k == 1) {
            return 0;
        }

        Arrays.sort(nums);
        int minn = Integer.MAX_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {

            int diff = nums[i + k - 1] - nums[i];

            if (diff < minn) {
                minn = diff;
            }
        }

        return minn;
    }

    public static void main(String[] args) {

        int[] nums = {9, 4, 1, 7};
        int k = 2;

        int ans = minimumDifference(nums, k);
        System.out.println("Min Diff - " + ans);

    }
    
}