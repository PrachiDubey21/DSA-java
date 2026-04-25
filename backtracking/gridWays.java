public class gridWays {

     public static int ways(int i, int j, int row, int col, int[][] dp) {

        // base case
        if (i == row - 1 && j == col - 1) {
            return 1;
        }

        // out of boundary
        if (i >= row || j >= col) {
            return 0;
        }

        // if already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // down
        int way1 = ways(i + 1, j, row, col, dp);

        // right
        int way2 = ways(i, j + 1, row, col, dp);

        // store and return
        return dp[i][j] = way1 + way2;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;

         int[][] dp = new int[m][n];

        // fill dp with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(ways(0, 0, n, m ,dp));

        //in linear time
        //using permutation
        
    }

}
