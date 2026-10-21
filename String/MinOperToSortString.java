import java.util.*;

public class MinOperToSortString {

    public static int minOperations(String s) {
        int n = s.length();

        boolean sort = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sort = false;
                break;
            }
        }

        if (sort) {
            return 0;
        }

        if (n == 2) {
            return -1;
        }

        char min = s.charAt(0);
        char max = s.charAt(0);

        for (int i = 1; i < n; i++) {
            min = (char) Math.min(min, s.charAt(i));
            max = (char) Math.max(max, s.charAt(i));
        }

        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }

        return 3;
    }

    public static void main(String[] args) {

        String s = "dcba";
        System.out.println(minOperations(s));
        
    }
}