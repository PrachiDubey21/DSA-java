import java.util.*;

public class ValueOfParenthesis {

    public static int scoreOfParentheses(String s) {

        int open = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                open++;
            }
            else {

                open--;

                if (s.charAt(i - 1) == '(') {
                    ans = ans + (1 << open);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "()()()";

        int result = scoreOfParentheses(s);
        System.out.println(result);

    }
    
}