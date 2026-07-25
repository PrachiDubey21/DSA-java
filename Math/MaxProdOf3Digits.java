import java.util.*;

public class MaxProdOf3Digits {

    public static int maximumProduct(int[] nums) {

        int largest = Integer.MIN_VALUE;
        int seclar = Integer.MIN_VALUE;
        int thirdlar = Integer.MIN_VALUE;

        int smallest = Integer.MAX_VALUE;
        int secsmall = Integer.MAX_VALUE;

        for (int num : nums) {

            if (num > largest) {
                thirdlar = seclar;
                seclar = largest;
                largest = num;
            } 
            else if (num > seclar) {
                thirdlar = seclar;
                seclar = num;
            } 
            else if (num > thirdlar) {
                thirdlar = num;
            }
            
            if (num < smallest) {
                secsmall = smallest;
                smallest = num;
            } 
            else if (num < secsmall) {
                secsmall = num;
            }
        }

        int prod1 = largest * seclar * thirdlar;
        int prod2 = largest * smallest * secsmall;

        return Math.max(prod1, prod2);
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-10, -10, 5, 2};

        System.out.println(maximumProduct(nums1));
        System.out.println(maximumProduct(nums2));

    }
    
}