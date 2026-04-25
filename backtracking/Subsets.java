import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void find(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }

        // choice
        // yes
        find(str, ans + str.charAt(i), i + 1);

        // no
        find(str, ans, i + 1);

    }

    public static void find(int[] nums, List<Integer> ans,
            int i, List<List<Integer>> result) {
        // base case
        if (i == nums.length) {
            result.add(new ArrayList<>(ans)); // store a copy
            return;
        }

        // YES → include nums[i]
        ans.add(nums[i]);
        find(nums, ans, i + 1, result);

        // backtrack
        ans.remove(ans.size() - 1);

        // NO → do not include nums[i]
        find(nums, ans, i + 1, result);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        find(nums, new ArrayList<>(), 0, result);
        return result;
    }

    public static void main(String[] args) {
        String str = "abc";

        find(str, "", 0);

        System.out.println();

         int nums[] = {1, 2, 3};

        List<List<Integer>> ans = subsets(nums);
        System.out.println(ans);
    }

}
