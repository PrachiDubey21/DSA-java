import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();

            //sort
            Arrays.sort(chars);

            String key = new String(chars);

            //add to map

            //  if (!map.containsKey(key)) {
            //     map.put(key, new ArrayList<>());
            // }

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

        List<List<String>> result = groupAnagrams(strs);

        System.out.println(result);
    }

}
