public class CatalansNumber {

    public static int catalanrecu(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = ans + catalanrecu(i) * catalanrecu(n - 1 - i);
        }

        return ans;
    }

    public static int catalanmemo(int n, int dp[]) {

        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = ans + catalanrecu(i) * catalanrecu(n - 1 - i);
        }

        return dp[n] = ans;
    }

    public static int catalantabu(int n) {

        int dp[] = new int[n + 1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];

    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println("recusrion : " + catalanrecu(n));

        int dp[] = new int[n + 1];
        System.out.println("memoisation : " + catalanmemo(n, dp));

        System.out.println("tabulation : " + catalantabu(n));

    }

}
