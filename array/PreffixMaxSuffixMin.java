import java.util.*;

public class PreffixMaxSuffixMin {

    public static int StableIndex(int[] nums, int k) {

        int prefix[] = new int[nums.length];
        prefix[0] = nums[0];

        int suffix[] = new int[nums.length];
        suffix[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = Math.max(nums[i], prefix[i - 1]);
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = Math.min(nums[i], suffix[i + 1]);
        }

        for (int i = 0; i < nums.length; i++) {

            if (prefix[i] - suffix[i] <= k) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {5, 2, 3, 1};
        int k = 3;

        int ans = StableIndex(nums, k);
        System.out.println(ans);
        
    }
    
}