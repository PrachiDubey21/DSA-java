import java.util.*;

public class AddAndMultiplyNonZero {

    public static long sumAndMultiply(int n) {

        int num = n;
        int rev = 0;

        while (num != 0) {

            int last = num % 10;

            if (last == 0) {
                num = num / 10;
                continue;
            }

            rev = rev * 10 + last;
            num = num / 10;
        }

        int con = 0;
        int sum = 0;

        while (rev != 0) {

            int last = rev % 10;
            sum = sum + last;
            con = con * 10 + last;
            rev = rev / 10;
        }

        return (long) con * sum;
    }

    public static void main(String[] args) {

        int n = 10230; 

        long ans = sumAndMultiply(n);

        System.out.println("Input = " + n);
        System.out.println("Answer = " + ans);

    }
    
}
