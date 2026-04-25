public class EditDistance {

    public static int ED(String str1, String str2, int n, int m) {

        if (n == 0) {
            return m; // insert all characters of str2
        }
        if (m == 0) {
            return n; // delete all characters of str1
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return ED(str1, str2, n - 1, m - 1);
        } else {

            // replace
            int ans1 = 1 + ED(str1, str2, n - 1, m - 1);

            // add
            int ans2 = 1 + ED(str1, str2, n, m - 1);

            // delete
            int ans3 = 1 + ED(str1, str2, n - 1, m);

            int finalans = Math.min(ans1, ans2);
            finalans = Math.min(ans3, finalans);

            return finalans;

        }

    }

    public static int EDmemo(String str1, String str2, int n, int m, int dp[][]) {

        // o (n*m)

        if (n == 0) {
            return m; // insert all characters of str2
        }
        if (m == 0) {
            return n; // delete all characters of str1
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = EDmemo(str1, str2, n - 1, m - 1, dp);
        } else {

            // replace
            int ans1 = 1 + ED(str1, str2, n - 1, m - 1);

            // add
            int ans2 = 1 + ED(str1, str2, n, m - 1);

            // delete
            int ans3 = 1 + ED(str1, str2, n - 1, m);

            int finalans = Math.min(ans1, ans2);
            finalans = Math.min(ans3, finalans);

            return dp[n][m] = finalans;
        }

    }

    public static int EDtabu(String str1, String str2) {
        // o (n*m) + without stack overloading

        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

        // when i == 0 then dp[i][j] = j
        // when j == 0 then dp[i][j] = i

        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < dp[0].length; j++) {

                if (i == 0) {
                    dp[i][j] = j;
                }

                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        // loop
        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    // replace
                    int ans1 = 1 + dp[i-1][j-1];

                    // add
                    int ans2 = 1 +  dp[i][j-1];

                    // delete
                    int ans3 = 1 +  dp[i-1][j];

                    int finalans = Math.min(ans1, ans2);
                    finalans = Math.min(ans3, finalans);

                    dp[i][j] = finalans;
                }

            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {

        String str1 = "intention";
        int n = str1.length();
        String str2 = "execution";
        int m = str2.length();

        // recursion
        System.out.println("recursion : " + ED(str1, str2, n, m));

        // memoisation
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("memoisation : " + EDmemo(str1, str2, n, m, dp));

        // tabulation
        System.out.println("tabulation : " + EDtabu(str1, str2));

    }

}
