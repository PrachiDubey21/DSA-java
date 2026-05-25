import java.util.*;

public class ReverseWordsInString {


    public static String reverseWords(String s) {

        String[] words = s.split(" ");

        StringBuilder result = new StringBuilder();

        for(String word : words) {

            StringBuilder sb = new StringBuilder(word);

            sb.reverse(); 

            result.append(sb); 
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {

        String s = "Let's code Java";

        String result = reverseWords(s);
        System.out.println(result);
    }
    
}
