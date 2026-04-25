import java.util.*;

public class ClimbingStairs {

     public static int ClimbingStairstab(int n, int[] dp) {

        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int ClimbingStairsMemo(int n, int[] dp) {

        // Base cases
        if (n == 0) {
            return 1;
        }
        if(n < 0 ){
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = ClimbingStairsMemo(n - 1, dp) + ClimbingStairsMemo(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5;

        int[] dp = new int[n + 1];

        int result = ClimbingStairsMemo(n, dp);

        System.out.println("ways of " + n +  " stairs is: " + result);
    }
    
}
