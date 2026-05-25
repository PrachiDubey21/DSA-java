import java.util.*;

public class DisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            // Convert value into index
            int index = Math.abs(nums[i]) - 1;

            // (means number 'index+1' is present in array)
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // index+1 was never visited so missing number
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                result.add(i + 1);
            }

        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };

        List<Integer> result = findDisappearedNumbers(nums);
        System.out.println(result); // Output: [5, 6]

    }

}
