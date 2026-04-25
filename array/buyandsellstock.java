import java.util.*;

// You are given an array prices 
// where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day
//  to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction.
//  If you cannot achieve any profit, return 0.

public class buyandsellstock {

    public static int Besttime(int price[]) {

        int maxProfit = 0;
        int n = price.length;

        // WE CAN WRITE THIS
        int Buyprice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (Buyprice < price[i]) { // current day price or selling price
                int profit = price[i] - Buyprice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                Buyprice = price[i];
            }
        }

        // OR
        // int Buyprice = price[0];
        // for (int i = 0; i < n; i++) {

        // int profit = price[i] - (Buyprice = Math.min(Buyprice, price[i]));
        // maxProfit = Math.max(maxProfit, profit);

        // }

        return maxProfit;
    }

    public static void main(String[] args) {
        int price[] = { 7, 1, 5, 3, 6, 4 };

        System.out.println("The profit for this stocks is : " + Besttime(price));
    }

}
