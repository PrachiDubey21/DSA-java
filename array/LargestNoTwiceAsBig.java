import java.util.*;

public class LargestNoTwiceAsBig {

    public static int dominantIndex(int[] nums) {

        int lar = Integer.MIN_VALUE;
        int seclar = Integer.MIN_VALUE;
        int ind = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > lar) {

                seclar = lar;
                lar = nums[i];
                ind = i;

            } 
            else if (nums[i] > seclar) {
                seclar = nums[i];
            }
        }

        if (lar >= 2 * seclar) {
            return ind;
        }

        return -1;
    }


    public static void main(String[] args) {

        int[] nums = {3, 6, 1, 0};

        int result = dominantIndex(nums);
        System.out.println("Index = " + result);

    }
    
}