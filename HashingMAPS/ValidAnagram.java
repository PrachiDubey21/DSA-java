import java.util.*;

public class ValidAnagram {

    public static void main(String[] args) {

        String s = "knee";
        String t = "keen";

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        }

        Boolean ans = true;

        for (int i = 0; i < t.length(); i++) {

            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
            } else {
                ans = false;
                break;
            }
        }

        for (int val : map.values()) {
            if (val != 0) {
                ans = false;
                break;
            }
        }

        if (ans) {
            System.out.println("they are valid anagrams ");
        } else {
            System.out.println("they are  not valid anagrams ");
        }

    }
}
