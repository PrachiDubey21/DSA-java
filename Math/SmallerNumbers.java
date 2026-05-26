import java.util.*;

public class SmallerNumbers {

    public static void main(String[] args) {

        int nums[] = {8,1,2,2,3};

        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {

            int count = 0;

            for(int j = 0; j < n; j++) {

                // count numbers smaller than nums[i]
                if(nums[j] < nums[i]) {
                    count++;
                }
            }

            ans[i] = count;
        }

        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
    }
    
}
