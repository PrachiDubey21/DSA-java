import java.util.*;

public class ShuffleTheArray {

    public static void main(String[] args) {

        int[] nums = {2, 5, 1, 3, 4, 7};

        int n = 3;

        int[] ans = new int[2 * n];

        int index = 0;

        for(int i = 0; i < n; i++) {

            ans[index] = nums[i];
            index++;

            ans[index] = nums[i + n];
            index++;
        }

        System.out.println(Arrays.toString(ans));
    }
    
}
