import java.util.Arrays;

public class knapsack01 {

    public static int knapsack(int val[], int wt[], int W, int i) {
        //o(2^n)

        // base case
        if (W == 0 || i == 0) {
            return 0;
        }

        // i-1 as it starts with 0 based index
        if (wt[i - 1] <= W) {

            // include
            int ans1 = val[i - 1] + knapsack(val, wt, W = W - wt[i - 1], i - 1);

            // exclude
            int ans2 = knapsack(val, wt, W, i - 1);

            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, wt, W, i - 1);
        }
    }

    public static int knapsackMemo(int val[], int wt[], int W, int i, int dp[][]) {
      //o(i * W)

        // base case
        if (W == 0 || i == 0) {
            return 0;
        }

        if (dp[i][W] != -1) {
            return dp[i][W];
        }

        // i-1 as it starts with 0 based index
        if (wt[i - 1] <= W) {

            // include
            int ans1 = val[i - 1] + knapsackMemo(val, wt, W = W - wt[i - 1], i - 1, dp);

            // exclude
            int ans2 = knapsackMemo(val, wt, W, i - 1, dp);

            dp[i][W] = Math.max(ans1, ans2);
            return dp[i][W];

        } else {
            dp[i][W] = knapsackMemo(val, wt, W, i - 1, dp);
            return dp[i][W];
        }
    }

      public static int knapsackTabu(int val[], int wt[], int W) {
        //o(n * W)

        int n = val.length;

        int dp[][] = new int[n +1][W+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for(int i=1;i<n+1;i++){

            for(int j=1;j<W+1;j++){

                int value = val[i-1];
                int wgt = wt[i-1];

                if(wgt <= j){
                    dp[i][j] = Math.max(value + dp[i-1][j-wgt], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }


        return dp[n][W];
      
    }

    public static void main(String[] args) {

        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        System.out.println(knapsack(val, wt, W, val.length));

        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(knapsackMemo(val, wt, W, val.length, dp));

        System.out.println(knapsackTabu(val, wt, W));

    }

}
