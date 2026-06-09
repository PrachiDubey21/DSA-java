import java.util.*;

public class PartitionArrayAccToGivenPivot {

    public static int[] pivotArray(int[] nums, int pivot) {

        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for (int i = 0 ; i< nums.length ; i++) {

            int num = nums[i];

            if (num < pivot) {
                smaller.add(num);
            }
            else if (num == pivot) {
                equal.add(num);
            }
            else {
                greater.add(num);
            }
        }

        int[] ans = new int[nums.length];
        int p = 0;

        for (int num : smaller) {
            ans[p++] = num;
        }

        for (int num : equal) {
            ans[p++] = num;
        }

        for (int num : greater) {
            ans[p++] = num;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        int[] result = pivotArray(nums, pivot);
        System.out.println(Arrays.toString(result));

    }
    
}
