import java.util.*;

// Given n non-negative integers representing an elevation map
//  where the width of each bar is 1, 
//  compute how much water it can trap after raining.

public class trappedWater {

    public static int trap(int[] height) {
        int n = height.length;
        int res = 0, l = 0, r = n - 1;
        int rMax = height[r], lMax = height[l];
        while (l < r) {
            if (lMax < rMax) {
                l++;
                lMax = Math.max(lMax, height[l]);
                res += lMax - height[l];
            } else {
                r--;
                rMax = Math.max(rMax, height[r]);
                res += rMax - height[r];
            }
        }
        return res;
    }

    public static int TrappedWater(int height[]) {

        int n = height.length;

        // find left Max boundary
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);
        }

        // find right max boundary
        int rightmax[] = new int[n];
        rightmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        }

        // loop
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {

            // find min(maxleft,maxright)
            int waterlevel = Math.min(leftmax[i], rightmax[i]);

            // water = (wl-h[i])*width (in this case = 1)
            trappedWater += (waterlevel - height[i]);
        }

        return trappedWater;
    }

    public static void main(String[] args) {

        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println("the trapped water is : " + TrappedWater(height));
    }

}
