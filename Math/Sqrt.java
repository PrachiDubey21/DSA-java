import java.util.*;

public class Sqrt {

    public static int mySqrt(int x) {

        int start = 0;
        int end = x;
        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            long sqrt = (long) mid * mid;

            if (sqrt == x) {
                return mid;
            }

            if (sqrt < x) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int x = 8;
        int result = mySqrt(x);
        System.out.println("Square root of " + x + " = " + result);

    }
    
}