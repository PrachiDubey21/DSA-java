import java.util.*;

public class SetMisMatch {

    public static void main(String[] args) {

        int nums[] = {1,2,2,4};

        int[] ans = new int[2];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            // duplicate number
            if (nums[i] == nums[i + 1]) {
                ans[0] = nums[i];
            }

            // missing number
            if (nums[i + 1] - nums[i] > 1) {
                ans[1] = nums[i] + 1;
            }
        }

        // missing number is 1
        if (nums[0] != 1) {
            ans[1] = 1;
        }

        // missing number is n
        if (nums[nums.length - 1] != nums.length) {
            ans[1] = nums.length;
        }

        System.out.println("Answer : [" + ans[0] + "," + ans[1] + "]" );
    }

}
