import java.util.*;

public class IndianCoins {

    public static int totalcoins(int coins[], int amount) {

        int count = 0;

        Arrays.sort(coins);
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = coins.length - 1; i >= 0; i--) {

            if (coins[i] < amount) {

                // Find how many coins of this type we can take
                int num = amount / coins[i];

                //include this 
                for(int j=1;j<=num;j++){
                arr.add(coins[i]);
                }
                
                count += num;
                amount = amount - (num * coins[i]);

            }
        }
        
        for (int i=0;i<arr.size();i++){
            System.out.print(arr.get(i) + " ");
        }

        return count;

    }

    public static void main(String[] args) {

        int coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        int amount = 590;

        int ans = totalcoins(coins, amount);

        System.out.println("the total coins are : " + ans);
    }

}
