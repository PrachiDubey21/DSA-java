import java.util.*;

public class CarrotChopDown {

    public static int solve(int[] arr, int cuts) {

        int ans = 0;
        for (int x = 1; x <= cuts; x++) {

            int count = 0;

             for (int i = 0; i < arr.length; i++) {

                if (arr[i] == x) {
                    count++;
                }
                else if (arr[i] == 2 * x) {
                    count = count + 2;
                }
                else if (arr[i] > x) {
                    count++;
                }
            }


            ans = Math.max(ans, count);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 4};
        int maxcut = 4;

        int ans = solve(arr, maxcut);
        System.out.println(ans);
    }
    
}