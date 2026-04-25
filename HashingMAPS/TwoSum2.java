import java.util.*;

public class TwoSum2 {


    public static void twoSum(int[] arr, int target) {

        // Step 1: Sort array
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        // Step 2: Two pointer
        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {
                System.out.println(arr[left] + " , " + arr[right]);
                return;
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 4};
        int target = 6;

        twoSum(arr, target);
    }
    
}
