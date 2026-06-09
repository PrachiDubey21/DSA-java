import java.util.*;

public class MaximumTotalSubArray1 {

        public static long maxTotalValue(int[] nums, int k) {

            int largest = nums[0];
            int smallest = nums[0];

            for (int i = 0; i < nums.length; i++) {

                if (nums[i] > largest) {
                    largest = nums[i];
                }

                if (nums[i] < smallest) {
                    smallest = nums[i];
                }
            }

            long ans = largest - smallest;
            ans = ans * k;
            return ans;
        }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number : ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter values : ");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter no of subarray : ");
        int k = sc.nextInt();

        long ans = maxTotalValue(nums, k);
        System.out.println(ans);

        sc.close();
    }
}