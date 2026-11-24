import java.util.*;

public class LCM_GCDEqualsProd {

    public static int maxLength(int[] nums) {

        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            long product = 1;
            int gcd = 0;
            int lcm = 1;

            for (int j = i; j < n; j++) {

                product = product * nums[j];
                gcd = findGCD(gcd, nums[j]);
                lcm = (lcm / findGCD(lcm, nums[j])) * nums[j];

                if (product == (long) gcd * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }

                if (product > 25200) {
                    break;
                }
            }
        }

        return ans;
    }

    public static int findGCD(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 1, 2, 1, 1, 1 };

        int result = maxLength(nums);
        System.out.println(result);

    }

}