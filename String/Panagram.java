import java.util.*;

public class Panagram {

    public static boolean checkIfPangram(String sentence) {

        if (sentence.length() < 26) {
            return false;
        }

        int[] freq = new int[26];

        for (int i = 0; i < sentence.length(); i++) {

            char ch = sentence.charAt(i);
            freq[ch - 'a']++;
            
        }

        for (int i = 0; i < 26; i++) {

            if (freq[i] == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String sentence = "aacvfdsxzqwertyhgbnmjklpoiuy";
        boolean answer = checkIfPangram(sentence);
        System.out.println(answer);

    }
    
}
