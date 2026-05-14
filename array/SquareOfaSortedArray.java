import java.util.*;

public class SquareOfaSortedArray {

    public static void main(String[] args) {

        int[] nums = { -4, -1, 0, 3, 10 };

        int n = nums.length;

        int[] ans = new int[n];

        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {

            int leftSquare = nums[left] * nums[left];

            int rightSquare = nums[right] * nums[right];

            // Place larger square
            if (leftSquare > rightSquare) {

                ans[index] = leftSquare;

                left++;
            } else {

                ans[index] = rightSquare;

                right--;
            }

            index--;
        }

        System.out.println(Arrays.toString(ans));
    }

}
