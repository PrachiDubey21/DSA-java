import java.util.*;

public class WildcardMatching {

    public static boolean ismatching(String s, String p) {

        // dp array
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n + 1][m + 1];

        // initalize
        dp[0][0] = true;

        // if patterns is empty
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }

        // if string is empty
        for (int i = 1; i < dp[0].length; i++) {

            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = false;
            }
        }

        // loop
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                // case 1 same char or last char of pattern is ?
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // case 2
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }

                else {
                    dp[i][j] = false;
                }

            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {

        String s = "baaabab";
        String p = "a*****ab";

        System.out.println(ismatching(s, p));

    }

}
