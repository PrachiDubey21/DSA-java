import java.util.*;

public class MaxProfitAfterBuyingAndSellingStocks {

    public static void maxProfit(int[] prices, int fee) {

        // Max Profit (Multiple Transactions - DP)
        int hold = -prices[0];
        int cash = 0;

        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, cash - prices[i]);
            cash = Math.max(cash, hold + prices[i] - fee);
        }

        System.out.println("Max Profit: " + cash);

        // First Profitable Transaction (Day Difference)
        int buyDay = 0;
        int sellDay = 0;

        int minPrice = prices[0];
        int minDay = 0;

        for (int i = 1; i < prices.length; i++) {

            // Check if selling today gives profit (after fee)
            if (prices[i] - minPrice - fee > 0) {
                buyDay = minDay;
                sellDay = i;
                break; // FIRST valid transaction
            }

            // Update minimum price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                minDay = i;
            }
        }

        int diff = sellDay - buyDay;

        System.out.println("Day Difference: " + diff);
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 7, 2, 8, 4};
        int fee = 2;
        maxProfit(arr, fee);
    }
}