import java.util.*;

public class FindOddLengthSumOfSubArray {

    public static int sumOddLengthSubarrays(int[] arr) {

        int n = arr.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {

                sum += arr[j];

                int length = j - i + 1;

                if (length % 2 != 0) {
                    ans += sum;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 4, 2, 5, 3 };

        System.out.println(sumOddLengthSubarrays(arr));
    }

}
