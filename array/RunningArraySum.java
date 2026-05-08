import java.util.*;

public class RunningArraySum {

    public static int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        System.out.print("Original Array: ");

        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] result = runningSum(nums);

        System.out.print("Running Sum Array: ");

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    
}
