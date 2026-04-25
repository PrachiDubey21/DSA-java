import java.util.Arrays;

public class MCM {

    public static int mcmrecu(int arr[], int i, int j) {

        // base case
        if (i == j) {
            return 0;
        }

        int finalans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {

            int cost1 = mcmrecu(arr, i, k);
            int cost2 = mcmrecu(arr, k + 1, j);

            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int ans = cost1 + cost2 + cost3;

            finalans = Math.min(finalans, ans);

        }

        return finalans;

    }

    public static int mcmmemo(int arr[], int i, int j, int dp[][]) {
        // o (n2)

        // base case
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int finalans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {

            int cost1 = mcmmemo(arr, i, k, dp);
            int cost2 = mcmmemo(arr, k + 1, j, dp);

            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int ans = cost1 + cost2 + cost3;

            finalans = Math.min(finalans, ans);

        }

        return dp[i][j] = finalans;

    }

    public static int mcmtabu(int arr[]) {

        // creation
        int n = arr.length;
        int dp[][] = new int[n][n];

        // intialization
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                }
            }
        }

        // loop
        for (int len = 2; len < n; len++) {

            // row
            for (int i = 1; i <= n - len; i++) {

                // col
                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;

                // calculate
                for (int k = i; k < j ; k++) {

                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];

                    int cost3 = arr[i - 1] * arr[k] * arr[j];
                    int ans = cost1 + cost2 + cost3;

                    dp[i][j] = Math.min(dp[i][j], ans);

                }

            }
        }

        return dp[1][n - 1];

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;

        System.out.println("Recursion : " + mcmrecu(arr, 1, n - 1));

        int dp[][] = new int[n][n];

        // for (int i = 0; i < dp.length; i++) {
        // for (int j = 0; j < dp[0].length; j++) {
        // dp[i][j] = -1;
        // }
        // }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println("Memoisation : " + mcmmemo(arr, 1, n - 1, dp));

        System.out.println("Memoisation : " + mcmtabu(arr));

    }

}
