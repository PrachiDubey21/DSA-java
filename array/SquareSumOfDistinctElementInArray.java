import java.util.*;

public class SquareSumOfDistinctElementInArray {

    public static int sumCounts(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < n; j++) {
                set.add(nums[j]);

                int count = set.size();
                ans += count * count;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};

        int result = sumCounts(nums);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Sum of squares: " + result);
    }
    
}