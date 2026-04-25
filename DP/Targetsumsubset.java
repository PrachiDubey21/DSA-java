import java.util.*;

public class Targetsumsubset {

    
      public static boolean targetsumTabu(int number[], int sum) {
        //o(n * W)

        int n = number.length;

        boolean dp[][] = new boolean[n +1][sum+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

         for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = false;
        }

        for(int i=1;i<n+1;i++){

            for(int j=1;j<sum+1;j++){

                if(number[i-1] <= j && dp[i-1][j-number[i-1]]){
                    dp[i][j] = true;
                }
                else if(dp[i-1][j]){
                    dp[i][j] = true;
                }

            }
        }

        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         System.out.print(dp[i][j] + "  ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();


        return dp[n][sum];
      
    }

    
    public static void main(String[] args) {

        int num[] = { 4,2,7,1,3 };
        int sum = 10;

        System.out.println(targetsumTabu(num, sum));


    }
    
}
