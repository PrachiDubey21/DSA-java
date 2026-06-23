import java.util.*;

public class RearrangeString {

    public static String sortSentence(String s) {

        String[] words = s.split(" ");
        String[] result = new String[words.length];

        for (String word : words) {

            int pos = word.charAt(word.length() - 1) - '0';
            result[pos - 1] = word.substring(0, word.length() - 1);

        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < result.length; i++) {

            ans.append(result[i]);

            if (i != result.length - 1) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));

    }

}
