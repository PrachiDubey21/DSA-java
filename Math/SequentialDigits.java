import java.util.*;

public class SequentialDigits {

    public static List<Integer> sequentialDigits(int low, int high) {

        ArrayList<Integer> ans = new ArrayList<>();

        int lowDigits = 0;
        int lowCopy = low;

        while (lowCopy > 0) {
            lowDigits++;
            lowCopy /= 10;
        }

        int highDigits = 0;
        int highCopy = high;

        while (highCopy > 0) {
            highDigits++;
            highCopy /= 10;
        }

        for (int len = lowDigits; len <= highDigits; len++) {

            for (int start = 1; start <= 10 - len; start++) {

                int num = 0;
                int digit = start;

                for (int i = 0; i < len; i++) {
                    num = num * 10 + digit;
                    digit++;
                }

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int low = 100;
        int high = 13000;

        List<Integer> result = sequentialDigits(low, high);
        System.out.println("Sequential Digits: " + result);

    }
}