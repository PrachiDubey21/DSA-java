public class FindMinInARotatedSortedArray2 {

    // Function to find minimum element
    public static int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            // Minimum is in right half
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }

            // Minimum is in left half including mid
            else if (nums[mid] < nums[high]) {
                high = mid;
            }

            // Duplicate case
            else {
                high--;
            }
        }

        return nums[low];
    }

    // Main function
    public static void main(String[] args) {

        // Rotated sorted array with duplicates
        int[] nums = {2, 2, 2, 0, 1};

        // Print array
        System.out.print("Array: ");

        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();

        // Find minimum
        int result = findMin(nums);

        // Print answer
        System.out.println("Minimum Element: " + result);
    }
}