import java.util.*;

public class MorseCode {

    public static int uniqueMorseRepresentations(String[] words) {

        String[] morse = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        HashSet<String> set = new HashSet<>();

        for (String word : words) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {

                char ch = word.charAt(i);
                sb.append(morse[ch - 'a']);
                
            }

            set.add(sb.toString());
        }

        return set.size();
    }

    public static void main(String[] args) {

        String[] words = { "gin", "zen", "gig", "msg" };

        int result = uniqueMorseRepresentations(words);
        System.out.println(result);

    }

}
