import java.util.*;

public class LongestValidParanthesis {

    public static int longestValidParentheses(String s) {

        int ans = 0;
        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            }
            else {
                close++;
            }

            if (open == close) {
                ans = Math.max(ans, open * 2);
            }

            if (close > open) {
                open = 0;
                close = 0;
            }
        }

        open = 0;
        close = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (ch == ')') {
                close++;
            }
            else {
                open++;
            }

            if (open == close) {
                ans = Math.max(ans, open * 2);
            }

            if (open > close) {
                open = 0;
                close = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = ")()())";

        System.out.println(s);
        int result = longestValidParentheses(s);
        System.out.println(result);

    }
    
}