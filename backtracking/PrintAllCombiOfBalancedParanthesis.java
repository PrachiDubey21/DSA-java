import java.util.*;

public class PrintAllCombiOfBalancedParanthesis {

    static void generate(int n, int open, int close, String str) {

        // Base case: valid combination formed
        if (str.length() == 2 * n) {
            System.out.println(str);
            return;
        }

        // Add opening bracket
        if (open < n) {
            generate(n, open + 1, close, str + "{");
        }

        // Add closing bracket
        if (close < open) {
            generate(n, open, close + 1, str + "}");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        generate(n, 0, 0, "");
    }
    
}
