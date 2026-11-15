import java.util.*;

public class SubArrayOddSum {

    public static int numOfSubarrays(int[] arr) {

        int n = arr.length;
        int[] prefix = new int[n];

        prefix[0] = arr[0] % 2;
        for(int i = 1; i < n; i++){
            prefix[i] = (prefix[i - 1] + arr[i]) % 2;
        }

        int even = 1;
        int odd = 0;

        for(int i = 0; i < n; i++){
            if(prefix[i] == 0){
                even++;
            }
            else {
                odd++;
            }
        }

        long ans = (long) even * odd;
        return (int) (ans % 1000000007);
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 5};

        int result = numOfSubarrays(arr);
        System.out.println("Number of subarrays with odd sum: " + result);
        
    }
}