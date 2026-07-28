import java.util.*;

public class SmallestPalindrome {

    public static String smallestPalindrome(String s) {

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {

            while (count[i] > 1) {
                left.append((char) ('a' + i));
                count[i] = count[i] - 2;
            }

            if (count[i] == 1) {
                middle = String.valueOf((char) ('a' + i));
            }
        }

        String first = left.toString();
        String second = left.reverse().toString();
        String ans = first+ middle + second;

        return ans;
    }

    public static void main(String[] args) {

        String s1 = "racecar";

        System.out.println("Input: " + s1);
        System.out.println("Output: " + smallestPalindrome(s1));

        System.out.println();
    }
}