import java.util.*;

public class ContiguousArray {
    public static void main(String[] args) {

        int[] nums = { 0, 1, 0, 0, 1, 1, 0 };

        // prefixSum -> first index
        HashMap<Integer, Integer> map = new HashMap<>();

        // sum 0 at index -1
        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            // 0 -> -1
            // 1 -> +1
            if (nums[i] == 0) {
                sum = sum - 1;
            } else {
                sum = sum + 1;
            }

            // If prefix sum already exists
            if (map.containsKey(sum)) {

                int length = i - map.get(sum);

                // Update maximum length
                maxLength = Math.max(maxLength, length);
            } else {
                // Store first occurrence
                map.put(sum, i);
            }
        }

        // Print answer
        System.out.println("Maximum Length = " + maxLength);
    }

}
