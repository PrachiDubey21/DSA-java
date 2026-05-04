import java.util.*;

public class LongestIncreasingPathInMatrix {

    static int N, M;
    static int[][] dp;

    static int dfs(int[][] mat, int i, int j) {

        // If already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int maxLen = 1; // at least the current cell

        // Move Down
        if (i + 1 < N && mat[i + 1][j] > mat[i][j]) {
            maxLen = Math.max(maxLen, 1 + dfs(mat, i + 1, j));
        }

        // Move Right
        if (j + 1 < M && mat[i][j + 1] > mat[i][j]) {
            maxLen = Math.max(maxLen, 1 + dfs(mat, i, j + 1));
        }

        return dp[i][j] = maxLen;
    }

    public static void main(String[] args) {

        int[][] mat = {
            {1, 2, 3, 4},
            {2, 2, 3, 4},
            {3, 2, 3, 4},
            {4, 5, 6, 7}
        };

        N = mat.length;
        M = mat[0].length;

        dp = new int[N][M];

        // Initialize dp with -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = -1;
            }
        }

        int result = dfs(mat, 0, 0);

        System.out.println("Longest Path Length: " + result);
    }
    
}
