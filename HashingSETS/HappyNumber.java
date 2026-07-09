import java.util.*;

public class HappyNumber {

    public static boolean isHappy(int n) {

        HashSet<Integer> sum = new HashSet<>();

        while (n != 1) {

            if (sum.contains(n)) {
                return false;
            }

            sum.add(n);
            n = nextsum(n);

        }

        return true;
    }

    public static int nextsum(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;
            sum = sum + (digit * digit);
            n = n / 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        int n = 19;

        System.out.println("Number - " + n);
        boolean ans = isHappy(n);

        if (ans) {
            System.out.println("Happy Number");
        } else {
            System.out.println("Not a Happy Number");
        }

    }

}
