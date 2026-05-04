import java.util.*;

public class CoinChange2 {

    // Function to find minimum coins
    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // Step 1: Fill with large value
        Arrays.fill(dp, amount + 1);

        // Step 2: Base case
        dp[0] = 0;

        // Step 3: Build DP array
        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // Step 4: Result
        if (dp[amount] > amount) {
            return -1;
        }

        return dp[amount];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of coins: ");
        int n = sc.nextInt();

        int[] coins = new int[n];

        System.out.println("Enter coin values:");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        int result = coinChange(coins, amount);

        if (result == -1) {
            System.out.println("Not possible to make the amount");
        } else {
            System.out.println("Minimum coins required: " + result);
        }

        sc.close();
    }
    
}
