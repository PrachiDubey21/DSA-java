package Parenthesis;
import java.util.*;

public class ValidParenthesis {

    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if (curr == '[' || curr == '{' || curr == '(') {
                st.push(curr);
            }
            else {

                if (st.isEmpty()) {
                    return false;
                }

                if ((st.peek() == '(' && curr == ')') ||
                        (st.peek() == '[' && curr == ']') ||
                        (st.peek() == '{' && curr == '}')) {

                    st.pop();

                }
                else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {

        String s = "({[]})";

        boolean result = isValid(s);
        System.out.println(result);

    }
}
