import java.util.*;

public class SortByFreq {

    public static String frequencySort(String s) {

        // Step 1: Count frequency
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Store characters
        List<Character> list = new ArrayList<>(map.keySet());

        // Step 3: Sort by frequency (descending)
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        // Step 4: Build result
        StringBuilder result = new StringBuilder();

        for (char c : list) {
            int freq = map.get(c);
            while (freq-- > 0) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "tree";
        System.out.println(frequencySort(s));
    }
    
}
