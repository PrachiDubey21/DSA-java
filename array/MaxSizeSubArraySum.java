import java.util.*;

public class MaxSizeSubArraySum {

    public static void main(String[] args) {

        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };

        int left = 0;
        int sum = 0;

        int minLength = Integer.MAX_VALUE;

        // Expand right pointer
        // Add elements to sum
        // When sum ≥ target
        // update minimum length
        // shrink from left

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {

                int currentLength = right - left + 1;
                minLength = Math.min(minLength, currentLength);

                sum -= nums[left];
                left++;

            }
        }

        // If no valid subarray found
        if (minLength == Integer.MAX_VALUE) {

            System.out.println(0);
        } else {
            System.out.println("Minimum Length = " + minLength);
        }
    }

}
