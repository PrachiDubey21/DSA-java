import java.util.*;

public class PivotIndex {

    // Function to find pivot index
    public static int pivotIndex(int[] nums) {

        // Calculate total sum
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // Left sum initially 0
        int leftSum = 0;

        // Traverse array
        for (int i = 0; i < nums.length; i++) {

            // Calculate right sum
            int rightSum = totalSum - leftSum - nums[i];

            // Check pivot condition
            if (leftSum == rightSum) {
                return i;
            }

            // Update left sum
            leftSum += nums[i];
        }

        // No pivot index found
        return -1;
    }

    // Main function
    public static void main(String[] args) {

        // Array given directly
        int[] nums = { 1, 7, 3, 6, 5, 6 };

        // Call function
        int result = pivotIndex(nums);

        // Print array
        System.out.print("Array: ");

        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();

        // Print pivot index
        System.out.println("Pivot Index: " + result);
    }

}
