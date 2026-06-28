import java.util.*;

// If a number is Even its binary always ends with 0
// If a number is odd its binary always ends with 1


// Example 1
// 5 -> Binary =101

// Remove last digit
// 10 which is 2
// dp[2] = 1

// Now look at the removed digit.
// It was 1 So 1 + 1 = 2

// Hence
// dp[5] = dp[2] + 1




// Example 2
// 6 -> Binary =110

// Remove last digit
// 11 which is 3
// dp[3] = 2

// Now look at the removed digit.
// It was 0 So 2 + 0 = 2

// Hence
// dp[6] = dp[3] + 0



// So the formula is 
// (number of 1s in the first part) + (last bit if it is 1)
// dp[i] = dp[i / 2] + (i % 2);

public class CountingBits {

    public static int[] countBits(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            dp[i] = dp[i / 2] + (i % 2);

        }

        return dp;
    }

    public static void main(String[] args) {

        int n = 5;

        int[] ans = countBits(n);
        System.out.println(Arrays.toString(ans));

    }
    
}
