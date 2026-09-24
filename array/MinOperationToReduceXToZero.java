import java.util.*;

public class MinOperationToReduceXToZero {

//min operation = arr length - no of elements in longest subarray with sum(total-x)
      
       public static int minOper(int[] nums, int x) {

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        if (target < 0) {
            return -1;
        }

        int left = 0;
        int sum = 0;
        int maxlength = -1;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                maxlength = Math.max(maxlength, right - left + 1);
            }
        }

        if (maxlength == -1) {
            return -1;
        }

        return nums.length - maxlength;
    }

    public static void main(String[] args) {

        int[] nums = {2,4,6,1,7,2};
        int x = 10;

        int result = minOper(nums, x);
        System.out.println(result);

    }
    
}

