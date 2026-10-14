import java.util.*;

public class SumNum {

    public static String maxSumOfSquares(int num, int sum) {

        StringBuilder string = new StringBuilder();
        int len = 0;

        while (len != num) {
            int curr = Math.min(9, sum);
            sum = sum - curr;

            if (sum < 0) {
                return "";
            }

            string.append(curr);
            len++;
        }

        if (sum != 0) {
            return "";
        }

        return string.toString();
    }

    public static void main(String[] args) {

        int num = 3;
        int sum = 20;

        String result = maxSumOfSquares(num, sum);
        System.out.println(result);
        
    }
}
