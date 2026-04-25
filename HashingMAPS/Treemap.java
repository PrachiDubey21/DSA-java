import java.util.*;

public class Treemap {

    public static void main(String[] args) {

        TreeMap<String, Integer> map = new TreeMap<>();

        // put()
        map.put("Apple", 50);
        map.put("Banana", 30);
        map.put("Mango", 70);
        map.put("Orange", 40);

        // duplicate key
        map.put("Apple", 60);

        System.out.println("TreeMap:");
        System.out.println(map);

        // get()
        System.out.println("Value of Mango: " + map.get("Mango"));

        // remove()
        map.remove("Banana");
        System.out.println("After removing Banana:");
        System.out.println(map);

        // containsKey()
        System.out.println("Contains key Mango? " + map.containsKey("Mango"));

        // Iteration (sorted order)
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }

}
