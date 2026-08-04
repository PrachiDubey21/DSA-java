import java.util.*;

public class FindMissingElement {

    public static List<Integer> findMissingElements(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = min; i <= max; i++) {

            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 4, 6, 2, 3};

        List<Integer> result = findMissingElements(nums);
        System.out.println(result);
    }
    
}