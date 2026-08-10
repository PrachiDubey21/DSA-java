import java.util.*;

public class StoneGame {

    public static boolean winnerSquareGame(int n) {

        boolean[] dp = new boolean[n + 1];
        dp[0] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {

                int check = j * j;

                if (dp[i - check] == false) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 1;

        boolean result = winnerSquareGame(n);
        System.out.println(result);

    }
}