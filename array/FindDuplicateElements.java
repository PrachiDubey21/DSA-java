import java.util.*;

public class FindDuplicateElements {

    public static List<Integer> findDuplicatesSorting(int[] nums) {

        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i + 1]) {
                list.add(nums[i]);
            }
        }

        return list;
    }

    public static List<Integer> findDuplicatesHashSet(int[] nums) {

        HashSet<Integer> seen = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {

            if (seen.contains(num)) {
                list.add(num);
            } else {
                seen.add(num);
            }
        }

        return list;
    }

    public static List<Integer> findDuplicatesOptimal(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                list.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }

        return list;
    }

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println("Original Array: " + Arrays.toString(nums));

        System.out.println("\nSorting Approach:");
        System.out.println(findDuplicatesSorting(nums));

        System.out.println("\nHashSet Approach:");
        System.out.println(findDuplicatesHashSet(nums));

        System.out.println("\nOptimal Approach:");
        System.out.println(findDuplicatesOptimal(nums));
    }
    
}
