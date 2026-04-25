import java.util.*;

public class LongestWordInDictonary {

    public static String longestWord(String[] words) {

        // Step 1: Put words in set
        HashSet<String> set = new HashSet<>(Arrays.asList(words));

        String result = "";

        // Step 2: Check each word
        for (String word : words) {

            boolean valid = true;

            // Check all prefixes
            for (int i = 1; i < word.length(); i++) {

                String prefix = word.substring(0, i);

                if (!set.contains(prefix)) {
                    valid = false;
                    break;
                }
            }

            // Step 3: Update result
            if (valid) {
                if (word.length() > result.length() ||
                        (word.length() == result.length() && word.compareTo(result) < 0)) {

                    result = word;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };

        System.out.println(longestWord(words));
    }

}
