import java.util.*;

public class NumberOfParenthesis {

    public static int countParenthesis(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n1 = 4;
        System.out.println("For n=4: " + countParenthesis(n1)); // 14

        int n2 = 3;
        System.out.println("For n=3: " + countParenthesis(n2)); // 5
    }
    
}
