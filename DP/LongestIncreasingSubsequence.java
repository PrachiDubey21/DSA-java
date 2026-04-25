import java.util.*;

public class LongestIncreasingSubsequence {

    public static int LIS(int arr[]) {
        // o (n*m)

        //add unique numbers
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        // add numbers back in array
        int arr2[] = new int[set.size()];

        int k = 0;
        for (int number : set) {
            arr2[k] = number;
            k++;
        }

        //sort the second array
        Arrays.sort(arr2);

        // LCS
        int n = arr.length;
        int m = arr2.length;

        int dp[][] = new int[n + 1][m + 1];

        // when length of arr1 is 0
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        // when length of arr2 is 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {

                if (arr[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i][j - 1]);
                }

            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {

        int arr[] = { 50, 3, 10, 7, 40, 80 };
        System.out.println("tabulation : " + LIS(arr));

    }

}
