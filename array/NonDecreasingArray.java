import java.util.*;

public class NonDecreasingArray {

     public static boolean checkPossibility(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {

                count++;

                if (count == 2) {
                    return false;
                }

                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
                else {
                    nums[i] = nums[i + 1];
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 2};

        boolean result = checkPossibility(nums);
        System.out.println(result);

    }
    
}