import java.util.*;

public class ValidParenthesisString {

    public static boolean checkValidString(String s) {

        int openexist = 0;
        int closeneed = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                openexist++;
                closeneed++;
            }

            else if (ch == ')') {
                openexist--;
                closeneed--;
            }

            else {
                openexist--;
                closeneed++;
            }

            openexist = Math.max(0, openexist);

            if (closeneed < 0) {
                return false;
            }
        }

        return openexist == 0;
    }

    public static void main(String[] args) {

        String s = "(*))";

        boolean result = checkValidString(s);
        System.out.println(result);

    }
    
}