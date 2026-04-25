import java.util.*;

public class MinEffortToReachEnd {

    public static int minCost(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        // Start
        dp[0][0] = grid[0][0];

        // First row
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // First column
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // Fill rest
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                dp[i][j] = grid[i][j] +
                           Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n-1][m-1];
    }

    public static void main(String[] args) {

        int[][] grid = {
            {31,100,65,12,18},
            {10,13,47,157,6},
            {100,113,174,11,33},
            {88,124,41,20,140},
            {99,32,111,41,20}
        };

        System.out.println("Minimum Cost: " + minCost(grid));
    }

    
}
