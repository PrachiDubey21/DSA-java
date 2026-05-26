import java.util.*;

public class CountNoOfSpecialChar {

    public static int numberOfSpecialChars(String word) {

        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }

        int count = 0;

        for(char ch = 'a'; ch <= 'z'; ch++) {

            // If both lowercase and uppercase exist
            if(set.contains(ch) && set.contains(Character.toUpperCase(ch))) {
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
