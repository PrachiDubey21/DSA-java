import java.util.*;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), ans);
        return ans;

    }

    public static void backtrack(int start, int n, int k, List<Integer> curr,
            List<List<Integer>> ans) {

        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= n; i++) {

            curr.add(i);
            backtrack(i + 1, n, k, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {

        int n = 4;
        int k = 2;

        List<List<Integer>> result = combine(n, k);
        System.out.println(result);
        
    }

}