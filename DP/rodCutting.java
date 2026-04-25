import java.util.Arrays;

public class rodCutting {

    
      public static int cutting(int length[], int price[], int len) {
        //o(n * W)

        int n = length.length;

        int dp[][] = new int[n +1][len+1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for(int i=1;i<n+1;i++){

            for(int j=1;j<len+1;j++){

                if(length[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        return dp[n][len];
      
    }

     public static void main(String[] args) {

        int length[] = { 1,2,3,4,5,6,7,8 };
        int price[] = { 1,5,8,9,10,17,17,20 };
        int len = 8;

        System.out.println(cutting(length , price , len));


    }
    
    
}
