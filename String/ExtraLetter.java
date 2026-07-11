import java.util.*;

public class ExtraLetter {

    public static char findTheDifference(String s, String t) {

        int[] count = new int[26];
        char ans = ' ';

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                ans = (char) (i + 'a');
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "abcd";
        String t = "abcde";

        char result = findTheDifference(s, t);
        System.out.println("Extra letter is: " + result);

    }
    
}
