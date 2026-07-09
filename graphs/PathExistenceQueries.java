import java.util.*;

public class PathExistenceQueries {

    public static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] ans = new int[n];
        boolean[] edges = new boolean[queries.length];
        int groupNo = 0;

        ans[0] = 0;

        for (int i = 0; i < n - 1; i++) {

            if (Math.abs(nums[i] - nums[i + 1]) > maxDiff) {
                groupNo++;
            }

            ans[i + 1] = groupNo;
        }

        int j = 0;

        for (int[] query : queries) {

            int u = query[0];
            int v = query[1];

            if (ans[u] == ans[v]) {
                edges[j] = true;
            } else {
                edges[j] = false;
            }

            j++;
        }

        return edges;
    }

    public static void main(String[] args) {

        int n = 5;
        int[] nums = { 2, 4, 5, 12, 13 };
        int maxDiff = 3;

        int[][] queries = {
                { 0, 2 },
                { 1, 4 },
                { 3, 4 },
                { 0, 4 }
        };

        boolean[] result = pathExistenceQueries(n, nums, maxDiff, queries);

        System.out.println(Arrays.toString(result));
    }

}
