import java.util.*;

public class LargestGCD {

    public static int findGCD(int[] nums) {

        int largest = 0;
        int smallest = nums[0];

        for (int i = 0; i < nums.length; i++) {

            if (largest < nums[i]) {
                largest = nums[i];
            }

            if (smallest > nums[i]) {
                smallest = nums[i];
            }
        }

        int ans = 0;

        if (largest == smallest) {
            ans = largest;
        } else {

            for (int i = 1; i <= smallest; i++) {

                if (largest % i == 0 && smallest % i == 0) {
                    ans = i;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {2, 5, 6, 9, 10};

        int result = findGCD(nums);
        System.out.println("GCD = " + result);
        
    }
}
    

