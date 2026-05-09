import java.util.*;

public class RangeSumQuery {

    int[] prefix;

    public RangeSumQuery(int[] nums) {

        prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args) {

        int[] nums = { -2, 0, 3, -5, 2, -1 };

        // Create object
        RangeSumQuery obj = new RangeSumQuery(nums);

        // Queries
        System.out.println(obj.sumRange(0, 2)); // 1
        System.out.println(obj.sumRange(2, 5)); // -1
        System.out.println(obj.sumRange(0, 5)); // -3
    }
}
