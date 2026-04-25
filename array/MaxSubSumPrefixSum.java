import java.util.*;

public class MaxSubSumPrefixSum {

    public static void Subarray(int arr[]) {

        int sum = Integer.MIN_VALUE;
        int maxsum = Integer.MIN_VALUE;

        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        System.out.println();

        for (int start = 0; start < arr.length; start++) {

            for (int end = start; end < arr.length; end++) {

                if (start == 0) {
                    sum = prefix[end];
                } else {
                    sum = prefix[end] - prefix[start - 1];
                }
                System.out.println("Sum is : " + sum);
                maxsum = Math.max(maxsum, sum);
            }

        }
        System.out.println("MAXSum is : " + maxsum);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 5;
        int arr[] = new int[n];

        System.out.println("Enter " + n + " elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }

        Subarray(arr);

    }
}