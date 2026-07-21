import java.util.*;

public class DetectCaptial {


    public static boolean detectCapitalUse(String word) {

        if (word.length() == 1) {
            return true;
        }

        char ch = word.charAt(0);

        if (Character.isUpperCase(ch)) {

            if (Character.isUpperCase(word.charAt(1))) {

                for (int i = 2; i < word.length(); i++) {

                    if (!Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }

            } else {

                for (int i = 2; i < word.length(); i++) {

                    if (Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
            }

        }

        else {

            for (int i = 1; i < word.length(); i++) {

                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String word1 = "USA";
        String word2 = "Google";
        String word3 = "leetcode";
        String word4 = "FlaG";

        System.out.println(word1 + " -> " + detectCapitalUse(word1));
        System.out.println(word2 + " -> " + detectCapitalUse(word2));
        System.out.println(word3 + " -> " + detectCapitalUse(word3));
        System.out.println(word4 + " -> " + detectCapitalUse(word4));
    }
}