import java.util.*;

public class Tribonacci {

    public static void tribonacciDP(int n) {

        if (n == 0) {
            return;
        }

        int[] dp = new int[n];

        // Base cases
        if (n >= 1) dp[0] = 0;
        if (n >= 2) dp[1] = 0;
        if (n >= 3) dp[2] = 1;

        // Fill DP array
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        // Print result
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
    }

    public static void main(String[] args) {
        tribonacciDP(10);
    }
    
}
