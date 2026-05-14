import java.util.*;

public class SolveArrayByParity {
    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 4};

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {

            // Left is already even
            if(nums[left] % 2 == 0) {

                left++;
            }

            // Right is already odd
            else if(nums[right] % 2 == 1) {

                right--;
            }

            // Swap
            else {

                int temp = nums[left];

                nums[left] = nums[right];

                nums[right] = temp;

                left++;

                right--;
            }
        }

        // Print answer
        System.out.println(Arrays.toString(nums));
    }
    
}
