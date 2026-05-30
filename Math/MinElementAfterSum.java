import java.util.*;

public class MinElementAfterSum {

    public static int minElement(int[] nums) {

        int smallest = Integer.MAX_VALUE;

        for(int num : nums) {

            int sum = 0;

            while(num != 0) {

                int digit = num % 10;
                sum = sum + digit;
                num = num / 10;

            }

            smallest = Math.min(smallest, sum);
        }

        return smallest;
    }

    public static void main(String[] args) {

        int[] nums = {10, 12, 13, 14};

        int result = minElement(nums);
        System.out.println(result);
        
    }
    
}
