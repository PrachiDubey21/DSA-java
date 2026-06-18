import java.util.*;

public class MaxDepthOfParenthesis {

    public static int maxDepth(String s) {

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                count++;
            }

            else if (s.charAt(i) == ')') {
                count--;
            }

            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {

        String s = "(1+(2*3)+((8)/4))+1";

        int ans = maxDepth(s);

        System.out.println("String: " + s);
        System.out.println("Maximum Depth = " + ans);
    }
    
}
