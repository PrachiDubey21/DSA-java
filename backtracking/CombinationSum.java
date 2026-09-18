import java.util.*;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    public static void backtrack(int start, int[] candidates, int target,
        int sum, List<Integer> curr, List<List<Integer>> ans) {

        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (sum + candidates[i] > target) {
                break;
            }

            curr.add(candidates[i]);
            backtrack(i + 1, candidates, target, sum + candidates[i], curr, ans);
            curr.remove(curr.size() - 1);
            
        }
    }

    public static void main(String[] args) {

        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;

        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);

    }
}