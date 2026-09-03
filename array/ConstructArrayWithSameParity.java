import java.util.*;

public class ConstructArrayWithSameParity {

    public static boolean uniformArray(int[] nums) {

        int minodd = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 != 0) {
                minodd = Math.min(minodd, nums[i]);
            }
        }

        if (minodd == Integer.MAX_VALUE) {
            return true;
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 0) {

                if (nums[i] < minodd) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 6};

        boolean result = uniformArray(nums1);
        System.out.println(result);

    }
    
}