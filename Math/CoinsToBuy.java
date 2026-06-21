import java.util.*;

public class CoinsToBuy {

    public static int maxItems(int[] costs, int coins) {

        Arrays.sort(costs);

        int count = 0;

        for (int i = 0; i < costs.length; i++) {

            if (coins < costs[i]) {
                break;
            }

            count++;

            coins = coins - costs[i];
        }

        return count;
    }

    public static void main(String[] args) {

        int[] costs = {1, 3, 2, 4, 1};
        int coins = 7;

        int answer = maxItems(costs, coins);

        System.out.println("Maximum items = " + answer);

    }
    
}
