import java.util.*;

public class WeightOfWords {

    public static String mapWordWeights(String[] words, int[] weights) {

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            int totalwt = 0;

            for (int j = 0; j < word.length(); j++) {

                char ch = word.charAt(j);
                int ind = ch - 'a';

                totalwt = totalwt + weights[ind];
            }

            int rem = totalwt % 26;
            int pos = 25 - rem;

            char ch = (char) ('a' + pos);
            ans.append(ch);

        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String[] words = {"abc", "de"};

        int[] weights = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18,
            19, 20, 21, 22, 23, 24, 25, 26
        };

        String result = mapWordWeights(words, weights);
        System.out.println(result);

    }
    
}
