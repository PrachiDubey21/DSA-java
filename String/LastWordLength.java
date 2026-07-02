import java.util.*;

public class LastWordLength {

    public static int lengthOfLastWord(String s) {

        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (ch == ' ') {
                continue;
            }

            while (i >= 0 &&
                    ((ch >= 'A' && ch <= 'Z') ||
                            (ch >= 'a' && ch <= 'z'))) {

                count++;
                i--;

                if (i >= 0) {
                    ch = s.charAt(i);
                }
            }

            break;
        }

        return count;
    }

    public static void main(String[] args) {

        String s = "   fly me   to   the moon   ";
        System.out.println(lengthOfLastWord(s));

    }

}
