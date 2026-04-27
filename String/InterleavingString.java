import java.util.*;

public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {

        int n = s1.length();
        int m = s2.length();

        // Length check
        if (n + m != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        // Fill first column
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        // Fill first row
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                char c = s3.charAt(i + j - 1);

                dp[i][j] = (s1.charAt(i - 1) == c && dp[i - 1][j]) ||
                        (s2.charAt(j - 1) == c && dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter s1: ");
        String s1 = sc.nextLine();

        System.out.print("Enter s2: ");
        String s2 = sc.nextLine();

        System.out.print("Enter s3: ");
        String s3 = sc.nextLine();

        boolean result = isInterleave(s1, s2, s3);

        if (result) {
            System.out.println("Yes, s3 is an interleaving of s1 and s2");
        } else {
            System.out.println("No, s3 is NOT an interleaving");
        }

        sc.close();
    }

}
