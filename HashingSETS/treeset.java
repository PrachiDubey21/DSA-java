import java.util.*;

public class treeset {

    public static void main(String[] args) {

        TreeSet<Integer> set = new TreeSet<>();

        // add()
        set.add(40);
        set.add(10);
        set.add(30);
        set.add(20);
        set.add(10); // duplicate

        System.out.println(set); // sorted output

        // contains()
        System.out.println("Contains 30? " + set.contains(30));

        // remove()
        set.remove(20);
        System.out.println("After removing 20: " + set);

        // first() and last()
        System.out.println("First element: " + set.first());
        System.out.println("Last element: " + set.last());

        // Iteration
        for (int x : set) {
            System.out.println(x);
        }

        // clear()
        set.clear();
        System.out.println("After clear: " + set);
    }
}
