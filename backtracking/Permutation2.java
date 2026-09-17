import java.util.*;

public class Permutation2 {

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] arr = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), ans, arr);
        return ans;
    }

    public static void backtrack(int[] nums,List<Integer> curr,List<List<Integer>> ans,boolean[] arr) {

        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (arr[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !arr[i - 1]) {
                continue;
            }

            curr.add(nums[i]);
            arr[i] = true;

            backtrack(nums, curr, ans, arr);

            curr.remove(curr.size() - 1);
            arr[i] = false;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2};

        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);

    }
    
}