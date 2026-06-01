import java.util.*;

public class MINCostToBuyCandies {

    //for every 2 candies third candy is free but the cost of 
    //the free candy should be less than or equal to the
    //cheapest candy you previously bought

    //every third candy is free

    public static int minimumCost(int[] cost) {

        Arrays.sort(cost);

        int ans = 0;
        int count = 0;

        for(int i = cost.length - 1; i >= 0; i--) {

            count++;

            if(count == 3) {

                count = 0;
                continue;
            }

            ans += cost[i];
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] cost = {6, 5, 7, 9, 2, 2};

        int result = minimumCost(cost);

        System.out.println("Minimum Cost = " + result);
    }

    
}
