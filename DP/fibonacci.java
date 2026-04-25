import java.util.*;

public class fibonacci {
    //O(n)4/-*/ 

    public static int fibonacci(int n, int[] dp) {

        // Base cases
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int fibonacci2(int n, int[] dp) {

        // Base cases
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = fibonacci2(n - 1, dp) + fibonacci2(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 10;

        int[] dp = new int[n + 1];

        int result = fibonacci2(n, dp);

        System.out.println("Fibonacci of " + n + " is: " + result);
    }
}
