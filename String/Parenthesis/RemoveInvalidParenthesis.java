import java.util.*;

public class RemoveInvalidParenthesis {

    static Set<String> ans = new HashSet<>();
    static int minRemove = Integer.MAX_VALUE;

    public static List<String> removeInvalidParentheses(String s) {

        solve(s, 0, "", 0);

        return new ArrayList<>(ans);
    }

    public static void solve(String s, int index, String current, int removed) {

        if (index == s.length()) {

            if (isValid(current)) {

                if (removed < minRemove) {

                    ans.clear();

                    minRemove = removed;

                    ans.add(current);
                } else if (removed == minRemove) {

                    ans.add(current);
                }
            }

            return;
        }

        char ch = s.charAt(index);

        // Keep the character
        solve(s, index + 1, current + ch, removed);

        // Remove the character if it is a parenthesis
        if (ch == '(' || ch == ')') {

            solve(s, index + 1, current, removed + 1);
        }
    }

    public static boolean isValid(String s) {

        int open = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            }

            else if (ch == ')') {

                if (open == 0) {
                    return false;
                }

                open--;
            }
        }

        return open == 0;
    }

    public static void main(String[] args) {

        String s = "()())()";

        List<String> result = removeInvalidParentheses(s);
        System.out.println(result);

    }

}