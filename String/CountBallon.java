import java.util.*;

public class CountBallon {

    public static int maxNumberOfBalloons(String text) {

        int[] freq = new int[26];

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);
            freq[ch - 'a']++;

        }

        int b = freq['b' - 'a'];
        int a = freq['a' - 'a'];
        int l = freq['l' - 'a'] / 2;
        int o = freq['o' - 'a'] / 2;
        int n = freq['n' - 'a'];

        return Math.min(
                Math.min(b, a),
                Math.min(l, Math.min(o, n))
        );
    }

    public static void main(String[] args) {

        String text = "loonbalxballpoon";

        int answer = maxNumberOfBalloons(text);
        System.out.println(answer);

    }
    
}
