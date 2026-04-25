//big/small positive + big/smallpositive = positive
//big positive + small negative = positive
//small positive + big negative = negative (take zero instead)

import java.util.Scanner;

public class KadanesAlgoForMaxSubSum {

    public static int Subarray(int arr[]) {
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE;

        System.out.println();

        for (int i = 1; i < arr.length; i++) {

            System.out.println("current sum is : " +
                    currsum + " and Maximum Sum is : " + maxsum);
            // Decide whether to start a new subarray
            // or continue the existing one

            // currsum = Math.max(arr[i], currsum + arr[i]);
            // or
            currsum = currsum + arr[i];
            if (currsum < 0) {
                currsum = 0;
            }

            // Update maximum sum found so far

            maxsum = Math.max(maxsum, currsum);
        }

        System.out.println("current sum is : " +
                currsum + " and Maximum Sum is : " + maxsum);
        return maxsum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 8;
        int arr[] = new int[n];

        System.out.println("Enter " + n + " elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }

        // check if all elements are negative
        boolean t = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                t = false;
                break;
            }
        }
        int ans;
        if (t) {
            ans = arr[0];
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, arr[i]);
            }
        } else {
            ans = Subarray(arr);
        }
        System.out.println("Max sum is : " + ans);

    }
}
