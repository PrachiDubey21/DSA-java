import java.util.*;

public class BestTimeToBuyAndSellStocks {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {

            // update minimum price
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // calculate profit
            int profit = prices[i] - minPrice;

            // update maximum profit
            if(profit > maxProfit) {
                maxProfit = profit;
            }
        }

        System.out.println("Maximum Profit = " + maxProfit);
    }
    
}
