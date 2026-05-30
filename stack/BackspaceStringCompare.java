import java.util.*;

public class BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {

        return build(s).equals(build(t));
        
    }

    public static String build(String str) {

        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray()) {

            if(ch != '#') {
                stack.push(ch);
            }
            else if(!stack.isEmpty()) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "ab#c";
        String t = "ad#c";

        boolean result = backspaceCompare(s, t);

        System.out.println(result);
    }
    
}
