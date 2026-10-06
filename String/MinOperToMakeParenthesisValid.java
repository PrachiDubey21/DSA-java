import java.util.*;

public class MinOperToMakeParenthesisValid {  public static int minAddToMakeValid(String s) {

        int open = 0;
        int op = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            }
            else {

                if (open > 0) {
                    open--;
                }
                else {
                    op++;
                }
            }
        }

        return op + open;
    }

    public static void main(String[] args) {

        String s = "()))((";

        int result = minAddToMakeValid(s);
        System.out.println(result);

    }
    
}