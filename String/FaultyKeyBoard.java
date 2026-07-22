import java.util.*;

public class FaultyKeyBoard {

    public static String finalString(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'i') {
                sb.reverse();
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "string";

        String result = finalString(s);

        System.out.println("Input  : " + s);
        System.out.println("Output : " + result);

    }
    
}