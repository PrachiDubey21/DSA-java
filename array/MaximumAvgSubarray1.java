public class MaximumAvgSubarray1 {

    public static void main(String[] args) {

        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;

        //compute first window sum
        int windowSum = 0;

        for(int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // slide the window
        for(int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        // compute average
        double maxAvg = (double) maxSum / k;

        System.out.println("Maximum Average = " + maxAvg);
    }
    
}
