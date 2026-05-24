import java.util.*;

public class PerfectSquare {

    public static boolean isPerfectSquare(int num) {

        long low = 1;
        long high = num;

        while(low <= high) {

            long mid = low + (high - low) / 2;

            long square = mid * mid;

            if(square == num) {
                return true;
            }

            else if(square < num) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int num = 16;

        boolean result = isPerfectSquare(num);
        System.out.println(result);
    }
    
}
