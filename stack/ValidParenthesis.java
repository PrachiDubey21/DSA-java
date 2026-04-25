import java.util.Stack;

public class ValidParenthesis {

    public static boolean check(String str) {

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char curr = str.charAt(i);

            if (curr == '[' || curr == '{'
                    || curr == '(') {

                s.push(curr);

            } else {

                if (s.isEmpty()) {
                    return false;
                }

                // check pair
                if ((s.peek() == '(' && curr == ')') ||
                        (s.peek() == '[' && curr == ']') ||
                        (s.peek() == '{' && curr == '}')) {
                    s.pop();
                } else {
                    return false;
                }

            }

        }

        if (s.isEmpty()) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {

        String str = "[{}]([]){}";
        boolean ans = check(str);

        if (ans) {
            System.out.println(str + " is a valid parenthesis ");
        } else {
            System.out.println(str + " is not a valid parenthesis ");
        }

    }

}
