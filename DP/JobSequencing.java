import java.util.*;

public class JobSequencing {

    // Job class to store start time, end time, and profit
    static class Job {
        int start, end, profit;

        Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;

        // Step 1: Create Job array
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        // Step 2: Sort jobs based on end time (important for DP)
        Arrays.sort(jobs, (a, b) -> a.end - b.end);

        // Step 3: dp[i] = max profit till ith job
        int[] dp = new int[n];

        // Base case: first job profit
        dp[0] = jobs[0].profit;

        // Step 4: Process each job
        for (int i = 1; i < n; i++) {

            // Profit if we include current job
            int includeProfit = jobs[i].profit;

            // Find last job which doesn't overlap with current job
            int l = binarySearch(jobs, i);

            // If found, add its profit
            if (l != -1) {
                includeProfit += dp[l];
            }

            // Max of including or excluding current job
            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        // Final answer: max profit till last job
        return dp[n - 1];
    }

    // Binary Search to find last non-overlapping job
    static int binarySearch(Job[] jobs, int index) {

        int low = 0, high = index - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If current mid job ends before current job starts
            if (jobs[mid].end <= jobs[index].start) {

                // Check if next job also satisfies condition
                if (mid + 1 <= high && jobs[mid + 1].end <= jobs[index].start) {
                    low = mid + 1; // move right
                } else {
                    return mid; // found correct job
                }

            } else {
                high = mid - 1; // move left
            }
        }

        // No non-overlapping job found
        return -1;
    }

    public static void main(String[] args) {

        int[] start = { 1, 2, 3, 3 };
        int[] end = { 3, 4, 5, 6 };
        int[] profit = { 50, 10, 40, 70 };

        // Expected Output: 120
        System.out.println(jobScheduling(start, end, profit));
    }
}