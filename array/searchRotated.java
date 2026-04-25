import java.util.*;

public class searchRotated {

    public static int search(int[] nums, int target) {

        int left = 0;  // starting index
        int right = nums.length - 1; // ending index

        // Standard Binary Search loop
        while (left <= right) {

            int mid = (left + right) / 2; // middle index

            // If target is found at mid, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the LEFT HALF is sorted
            if (nums[left] <= nums[mid]) {

                // Check if target lies within this sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // search in left half
                } else {
                    left = mid + 1;  // search in right half
                }

            } else { // Otherwise, the RIGHT HALF must be sorted

                // Check if target lies in this sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // search in right half
                } else {
                    right = mid - 1; // search in left half
                }
            }
        }

        return -1; // If we exit the loop, target was not found
    }

    public static void main(String[] args) {

        int arr[] = { 7, 8, 9, 1, 2, 3, 4 };
        int target = 1;

        int result = search(arr, target);

        if (result == -1) {
            System.out.println("Target not found!");
        } else {
            System.out.println("Target found at index: " + result);
        }
    }
}

