import java.util.*;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4 };

        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];

        // Build left array
        left[0] = 1;

        for (int i = 1; i < n; i++) {

            left[i] = left[i - 1] * nums[i - 1];
        }

        // Build right array
        right[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {

            right[i] = right[i + 1] * nums[i + 1];
        }

        // Calculate answer array
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }

        // Print arrays
        System.out.println("Left Array  = " + Arrays.toString(left));
        System.out.println("Right Array = " + Arrays.toString(right));
        System.out.println("Answer Array = " + Arrays.toString(ans));
    }

}
