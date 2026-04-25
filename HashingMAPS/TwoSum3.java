import java.util.*;

public class TwoSum3 {


    static class Pair {
        int val;
        int index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static int[] twoSum(int[] arr, int target) {

        int n = arr.length;

        // Step 1: Store value + original index
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }

        // Step 2: Sort based on value
        Arrays.sort(pairs, (a, b) -> a.val - b.val);

        // Step 3: Two Pointer
        int left = 0;
        int right = n - 1;

        while (left < right) {

            int sum = pairs[left].val + pairs[right].val;

            if (sum == target) {
                return new int[]{
                    pairs[left].index,
                    pairs[right].index
                };
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 4};
        int target = 6;

        int[] result = twoSum(arr, target);

        System.out.println(result[0] + ", " + result[1]);
    }
    
}
