import java.util.*;

public class ProcessString {

    public static String processStr(String s) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {

                result.append(ch);

            } else if (ch == '*') {

                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }

            } else if (ch == '#') {

                String temp = result.toString();
                result.append(temp);

            } else if (ch == '%') {

                result.reverse();
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "a#b%*";

        String ans = processStr(s);

        System.out.println(ans);
    }
    
}
