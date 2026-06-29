import java.util.*;

public class MinCostToClimbStairs {

// Suppose you're standing on stair i

// to get here there are 2 way
// stair i-1
// stair i-2

// So choose whichever is cheaper
// dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);

// NOW

// The top has no cost.
// You can jump to the top from
// Last stair or Second last stair

// So answer is
// Math.min(dp[n-1], dp[n-2]);

    public static int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];


        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {

        int[] cost = {10, 15, 20};

        int answer = minCostClimbingStairs(cost);
        System.out.println("Minimum Cost = " + answer);
  
    }

}
