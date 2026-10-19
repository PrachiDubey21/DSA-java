import java.util.*;

public class IndexAfterSorting {

    public static List<Integer> targetIndices(int[] nums, int target) {

        int count = 0;
        int less = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                less++;
            } else if (nums[i] == target) {
                count++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        int start = less;

        for (int i = 0; i < count; i++) {
            ans.add(start++);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 2, 3};
        int target = 2;

        List<Integer> result = targetIndices(nums, target);
        System.out.println(result);

    }
}