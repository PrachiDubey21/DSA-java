import java.util.*;

public class MaxTwoFreqSubString {

    public static int maximumLengthSubstring(String s) {

        int freq[] = new int[26];
        int len = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {

            int idx = s.charAt(i) - 'a';
            freq[idx]++;

            while (freq[idx] > 2) {

                int lidx = s.charAt(left) - 'a';
                freq[lidx]--;

                left++;
            }

            len = Math.max(len, i - left + 1);
        }

        return len;
    }

    public static void main(String[] args) {

        String s = "bcbbbcba";

        int result = maximumLengthSubstring(s);
        System.out.println(result);

    }

}