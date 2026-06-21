import java.util.*;

public class MatchValue {

    public static int countMatches(List<List<String>> items, String Key,
         String Value) {

        int index = 0;

        if (Key.equals("type")) {
            index = 0;
        }

        if (Key.equals("color")) {
            index = 1;
        }

        if (Key.equals("name")) {
            index = 2;
        }

        int count = 0;

        for (int i = 0; i < items.size(); i++) {

            List<String> item = items.get(i);

            if (item.get(index).equals(Value)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        List<List<String>> items = new ArrayList<>();

        items.add(Arrays.asList("phone", "blue", "pixel"));
        items.add(Arrays.asList("computer", "silver", "lenovo"));
        items.add(Arrays.asList("phone", "gold", "iphone"));

        String ruleKey = "type";
        String ruleValue = "phone";

        int answer = countMatches(items, ruleKey, ruleValue);

        System.out.println("Answer = " + answer);

    }
    
}
