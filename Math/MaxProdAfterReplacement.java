import java.util.*;

public class MaxProdAfterReplacement {

    public static long maxProduct(int[] nums) {

        long largest = -1;
        long seclargest = -1;

        for (int num : nums) {

            long digit = Math.abs((long) num);

            if (digit > largest) {
                seclargest = largest;
                largest = digit;
            } else if (digit > seclargest) {
                seclargest = digit;
            }
        }

        return largest * seclargest * 100000L;
    }

    public static void main(String[] args) {

        int[] nums = {2, -8, 5, -10, 7};

        long ans = maxProduct(nums);
        System.out.println(ans);

    }
    
}