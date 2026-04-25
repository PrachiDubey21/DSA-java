public class LongestCommonSubString {

    public static int LCStabu(String str1, String str2) {
        // o (n*m) + without stack overloading

        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];
        int maxlen = 0;

        // when length of str1 is 0
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        // when length of str2 is 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                   dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxlen = Math.max(maxlen, dp[i][j]);
                } else {
                    dp[i][j] =  0;
                }

            }
        }

        return maxlen;

    }

    public static void main(String[] args) {

        String str1 = "abcdgh";
        String str2 = "acdghr";

        System.out.println("tabulation : " + LCStabu(str1, str2));

    }

}
