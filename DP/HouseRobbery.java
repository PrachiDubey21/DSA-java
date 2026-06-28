import java.util.*;

// If you rob it,
// 2  7  9  3  1
//       ↑
// you cannot rob the previous house.

// So money becomes
// current house
// +
// best till i-2
//or 
// simply keep whatever best answer you already had.

// dp[i] = max(
//     rob this house,
//     skip this house )

// or
// dp[i] = max(dp[i-1], nums[i] + dp[i-2])


public class HouseRobbery {

    public static int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {

            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);

        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 9, 3, 1};

        int answer = rob(nums);
        System.out.println("Maximum money that can be robbed = " + answer);
    }
    
}
