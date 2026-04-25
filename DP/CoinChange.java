import java.util.Arrays;

public class CoinChange {

          public static int change(int coin[], int sum) {
        //o(n * W)

        int n = coin.length;

        int dp[][] = new int[n +1][sum+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<dp[0].length;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<n+1;i++){

            for(int j=1;j<sum+1;j++){

                int value = coin[i-1];

                if(value <= j){
                    dp[i][j] = dp[i][j-value] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();


        return dp[n][sum];
      
    }

      public static void main(String[] args) {

        int coins[] = { 1,2,3};
        int sum = 4;

        System.out.println(change(coins,sum));


    }

    
}
