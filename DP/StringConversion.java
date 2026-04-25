public class StringConversion {

    public static int convert(String s1 , String s2){

        int len = LCS(s1, s2);

        int deletion = s1.length() - len;
        int insert = s2.length() - len;

        int totalOperation = deletion + insert ;

        return totalOperation;

    }

    public static int LCS(String str1, String str2) {
        // o (n*m) + without stack overloading

        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

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
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i][j - 1]);
                }

            }
        }

        return dp[n][m];

    }

    public static void main(String[] args){

        String s1 = "pear";
        String s2 = "sea";

        System.out.println(convert(s1, s2));

    }

}
