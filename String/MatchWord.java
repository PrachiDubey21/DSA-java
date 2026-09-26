import java.util.*;

public class MatchWord {

    public static String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < knowledge.size(); i++) {
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != '(') {
                ans += s.charAt(i);
                continue;
            }

            String word = "";
            i++;

            while (s.charAt(i) != ')') {
                word += s.charAt(i);
                i++;
            }

            if (map.containsKey(word)) {
                ans += map.get(word);
            } else {
                ans += "?";
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "(name)is(age)yearsold";

        List<List<String>> knowledge = new ArrayList<>();

        knowledge.add(Arrays.asList("name", "bob"));
        knowledge.add(Arrays.asList("age", "two"));

        System.out.println(evaluate(s, knowledge));

    }

}