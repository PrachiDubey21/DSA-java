import java.util.*;

public class SumEqualToIndex {

    public static int smallestIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            int sum = 0;

            while (num > 0) {
                int digit = num % 10;;
                sum += digit;
                num /= 10;
            }

            if (sum == i) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 10, 11};

        int result = smallestIndex(nums);
        System.out.println(result);

    }
}