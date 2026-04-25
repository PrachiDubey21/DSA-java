import java.util.*;

public class hashsets {

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        // add()
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10); // duplicate

        System.out.println(set);

        // contains()
        System.out.println("Contains 20? " + set.contains(20));

        // remove()
        set.remove(30);
        System.out.println("After removing 30: " + set);

        // size()
        System.out.println("Size: " + set.size());

        // isEmpty()
        System.out.println("Is empty? " + set.isEmpty());

        // Iteration
        for (int x : set) {
            System.out.println(x);
        }

        // clear()
        set.clear();
        System.out.println("After clear: " + set);
    }
}
