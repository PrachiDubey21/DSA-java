import java.util.*;

public class RotatedString {

    public static boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()) {
            return false;
        }

        // Concatenate string with itself
        String doubled = s + s;

        return doubled.contains(goal);
    }

    public static void main(String[] args) {

        String s = "abcde";
        String goal = "cdeab";

        boolean result = rotateString(s, goal);
        System.out.println(result);
        
    }
    
}
