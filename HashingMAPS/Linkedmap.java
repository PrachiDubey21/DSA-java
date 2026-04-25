import java.util.*;

public class Linkedmap {

    public static void main(String[] args) {

        // 1. Creating a LinkedHashMap (Insertion Order)
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        // 2. put() – Adding elements
        map.put("Apple", 50);
        map.put("Banana", 30);
        map.put("Mango", 70);
        map.put("Orange", 40);

        // Duplicate key (value will be replaced)
        map.put("Apple", 60);

        System.out.println("After put operation:");
        System.out.println(map);
        System.out.println();

        // 3. get() – Accessing value using key
        System.out.println("Value of Mango: " + map.get("Mango"));
        System.out.println();

        // 4. containsKey()
        System.out.println("Contains key Banana? " + map.containsKey("Banana"));

        // 5. containsValue()
        System.out.println("Contains value 40? " + map.containsValue(40));
        System.out.println();

        // 6. remove() – Removing element
        map.remove("Orange");
        System.out.println("After removing Orange:");
        System.out.println(map);
        System.out.println();

        // 7. size()
        System.out.println("Size of map: " + map.size());
        System.out.println();

        // 8. isEmpty()
        System.out.println("Is map empty? " + map.isEmpty());
        System.out.println();

        // 9. Iterating using entrySet()
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 10. keySet()
        System.out.println("Keys:");
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println();

        // 11. values()
        System.out.println("Values:");
        for (Integer value : map.values()) {
            System.out.println(value);
        }
        System.out.println();

        // 12. clear()
        map.clear();
        System.out.println("After clear operation:");
        System.out.println(map);
    }

}
