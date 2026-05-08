import java.util.*;

public class FindMinInARotatedSortedArray {

    public static int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        // Binary Search
        while (low < high) {

            int mid = low + (high - low) / 2;

            // Minimum lies in right half
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }

            // Minimum lies in left half including mid
            else {
                high = mid;
            }
        }

        // Minimum element
        return nums[low];
    }

    // Main function
    public static void main(String[] args) {

        // Rotated sorted array
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

        // Print array
        System.out.print("Array: ");

        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();

        // Find minimum element
        int result = findMin(nums);

        // Print result
        System.out.println("Minimum Element: " + result);
    }

}
