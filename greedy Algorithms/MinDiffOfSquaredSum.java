import java.util.*;

public class MinDiffOfSquaredSum {

    public static long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
        }

        long k = (long) k1 + k2;
        Arrays.sort(diff);

        while (k > 0 && diff[n - 1] > 0) {
            diff[n - 1]--;
            k--;
            Arrays.sort(diff);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans = ans + (long) diff[i] * diff[i];
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {2, 10, 20, 19};

        int k1 = 0;
        int k2 = 0;

        System.out.println(minSumSquareDiff(nums1, nums2, k1, k2));

    }    
}