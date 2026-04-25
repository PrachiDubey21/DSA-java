public class LongestCommonSubSequence {

    public static int LCS(String str1, String str2, int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return 1 + LCS(str1, str2, n - 1, m - 1);
        } else {
            return Math.max(LCS(str1, str2, n - 1, m),
                    LCS(str1, str2, n, m - 1));
        }

    }

    public static int LCSmemo(String str1, String str2, int n, int m, int dp[][]) {

        // o (n*m)

        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = 1 + LCSmemo(str1, str2, n - 1, m - 1, dp);
        } else {
            return dp[n][m] = Math.max(LCSmemo(str1, str2, n - 1, m, dp),
                    LCS(str1, str2, n, m - 1));
        }

    }

     public static int LCStabu(String str1, String str2) {
        //o (n*m) + without stack overloading

        int n= str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        //when length of str1  is 0
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = 0;
        }

        //when length of str2 is 0
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<dp.length;i++){

            for(int j=1;j<dp[0].length;j++){

            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            dp[i][j] = 1 + dp[i-1][j-1];
            }
            else{
                dp[i][j] = Math.max(dp[i-1][j],
                  dp[i][j-1]);
            }
         
        }
    }

    return dp[n][m];
   
}

    public static void main(String[] args) {

        String str1 = "abcde";
        int n = str1.length();
        String str2 = "ace";
        int m = str2.length();

        int ans = 0;

        System.out.println("recursion : " + LCS(str1, str2, n, m));

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("memoisation : " +LCSmemo(str1, str2, n, m, dp));

        System.out.println("tabulation : " +LCStabu(str1, str2));

    }

}
