import java.util.*;

public class MinInsertions {

    public static int minInsertions(String s) {
        
        int open = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {

                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    ans++;
                }

                if (open > 0) {
                    open--;
                } else {
                    ans++;
                }
            }
        }

        return ans + 2 * open;
    }

    public static void main(String[] args) {

        String s = "()))";

        int result = minInsertions(s);
        System.out.println(result);
    }

}