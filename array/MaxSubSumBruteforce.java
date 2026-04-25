import java.util.Scanner;

public class MaxSubSumBruteforce {

    public static int Subarray(int arr[]) {
        int sum = Integer.MIN_VALUE;
        int maxsum = Integer.MIN_VALUE;

        System.out.println();

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + arr[k];
                }

                maxsum = Math.max(maxsum, sum);

            }

        }

        return maxsum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 5;
        int arr[] = new int[n];

        System.out.println("Enter " + n + " elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }

        int ans = Subarray(arr);
        System.out.println("Max sum is : " + ans);

    }
}
