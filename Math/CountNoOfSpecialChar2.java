import java.util.*;

public class CountNoOfSpecialChar2 {

    public static int numberOfSpecialChars(String word) {

        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];

        Arrays.fill(lastLower, -1);
        Arrays.fill(firstUpper, -1);

        for(int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if(Character.isLowerCase(ch)) {
                lastLower[ch - 'a'] = i;
            }

            else {

                int index = ch - 'A';

                if(firstUpper[index] == -1) {
                    firstUpper[index] = i;
                }
                
            }
        }

        int count = 0;

        // Check all characters
        for(int i = 0; i < 26; i++) {

            if(lastLower[i] != -1 &&
               firstUpper[i] != -1 &&
               lastLower[i] < firstUpper[i]) {

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String word = "aaAbcBC";

        int result = numberOfSpecialChars(word);
        System.out.println(result);
    
    }
    
}
