import java.util.*;

public class Linkedset {

    public static void main(String[] args) {

        LinkedHashSet<String> set = new LinkedHashSet<>();

        // add()
        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Apple"); // duplicate

        System.out.println(set); // insertion order

        // contains()
        System.out.println("Contains Mango? " + set.contains("Mango"));

        // remove()
        set.remove("Banana");
        System.out.println("After removing Banana: " + set);

        // size()
        System.out.println("Size: " + set.size());

        // Iteration using for-each
        for (String s : set) {
            System.out.println(s);
        }

        // clear()
        set.clear();
        System.out.println("After clear: " + set);
    }
}
