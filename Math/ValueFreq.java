import java.util.*;

public class ValueFreq {
    
    public static int[] decompressRLElist(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {

            int freq = nums[i];
            int val = nums[i + 1];

            for (int j = 0; j < freq; j++) {
                list.add(val);
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = decompressRLElist(nums);

        System.out.println("Decompressed Array:");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    
}
