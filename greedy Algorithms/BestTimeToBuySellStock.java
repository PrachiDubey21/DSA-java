public class BestTimeToBuySellStock {

    public static int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices1 = {7, 6, 4, 3, 1};
        int[] prices2 = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices1)); // 0
        System.out.println(maxProfit(prices2)); // 5
    }
}
