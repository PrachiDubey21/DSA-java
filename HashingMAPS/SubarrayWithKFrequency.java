import java.util.*;

public class SubarrayWithKFrequency {

    public static int maxLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int ans = 0;

        for (int r = 0; r < nums.length; r++) {

            int freq = map.getOrDefault(nums[r], 0) + 1;
            map.put(nums[r], freq);

            while (map.get(nums[r]) > k) {

                freq = map.get(nums[l]) - 1;
                map.put(nums[l], freq);

                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 1, 3};
        int k = 2;

        int result = maxLength(nums, k);
        System.out.println(result);

    }
}