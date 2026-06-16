import java.util.*;

public class MaxProductOfTwoElements1 {

    //by Sorting
    public static int maxProductSorting(int[] nums) {

        Arrays.sort(nums);

        int first = nums[nums.length - 1];
        int second = nums[nums.length - 2];

        return (first - 1) * (second - 1);
    }

    // Optimal O(n)
    public static int maxProductOptimal(int[] nums) {

        int largest = 0;
        int secondLargest = 0;

        for (int num : nums) {

            if (num > largest) {

                secondLargest = largest;
                largest = num;

            } else if (num > secondLargest) {

                secondLargest = num;
            }
        }

        return (largest - 1) * (secondLargest - 1);
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 2};

        int ans1 = maxProductSorting(nums);
        int ans2 = maxProductOptimal(nums);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Sorting Approach Answer : " + ans1);
        System.out.println("Optimal Approach Answer : " + ans2);
    }
}