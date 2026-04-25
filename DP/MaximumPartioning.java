import java.util.Arrays;

public class MaximumPartioning {
    // o(n*w)

    public static int partion(int nums[]) {

        int n = nums.length;
        int sum = 0;

        // sum
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }
        int W = sum / 2;

        // create dp
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        // knapsack
        for (int i = 1; i < n + 1; i++) {

            for (int j = 1; j < W + 1; j++) {

                int wt = nums[i - 1];

                // valid
                if (wt <= j) {
                    dp[i][j] = Math.max(wt + dp[i - 1][j - wt], dp[i - 1][j]);
                }
                // invalid
                else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum - sum1;

        return Math.abs(sum1 - sum2);

    }

    public static void main(String[] args) {

        int arr[] = { 1, 6, 11, 5 };
        System.out.println("tabulation : " + partion(arr));

    }

}
