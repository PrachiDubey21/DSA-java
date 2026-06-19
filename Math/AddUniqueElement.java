import java.util.*;

public class AddUniqueElement {

    public static int sumOfUnique(int[] nums) {

        int[] freq = new int[101];

        for (int num : nums) {
            freq[num]++;
        }

        int sum = 0;

        for (int num : nums) {

            if (freq[num] == 1) {
                sum += num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2};

        int answer = sumOfUnique(nums);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Sum of Unique Elements: " + answer);

    }

    
}
