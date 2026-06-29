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



}
