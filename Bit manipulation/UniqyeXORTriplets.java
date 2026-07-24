import java.util.*;

public class UniqyeXORTriplets {

    public static int uniqueXorTriplets(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return 1;

        HashSet<Integer> pair = new HashSet<>();
        HashSet<Integer> triplet = new HashSet<>();

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {
                pair.add(nums[i] ^ nums[j]);
            }
        }

        for (int pr : pair) {

            for (int num : nums) {
                triplet.add(pr ^ num);
            }
        }

        return triplet.size();
    }

    public static void main(String[] args) {

        int[] nums = {1, 3};
        System.out.println(uniqueXorTriplets(nums));

    }
    
}