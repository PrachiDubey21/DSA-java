import java.util.*;

public class MaxDepthAfterSplit {

    public static int[] maxDepthAfterSplit(String s) {

        int[] ans = new int[s.length()];
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                depth++;
                ans[i] = depth % 2;

            }
            else {
                ans[i] = depth % 2;
                depth--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "(()())";

        int[] ans = maxDepthAfterSplit(s);
        System.out.println(Arrays.toString(ans));

    }
}