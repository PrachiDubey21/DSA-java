import java.util.*;

public class DequeUsingFramework {

    public static void main(String[] args) {

        // Creating a Deque using ArrayDeque
        Deque<Integer> dq = new ArrayDeque<>();

        // Insert at rear
        dq.addLast(10);
        dq.addLast(20);

        // Insert at front
        dq.addFirst(5);
        dq.addFirst(2);

        System.out.println("Deque: " + dq);

        // Access first and last elements
        System.out.println("First Element: " + dq.getFirst());
        System.out.println("Last Element: " + dq.getLast());

        // Remove from both ends
        System.out.println("Removed Front: " + dq.removeFirst());
        System.out.println("Removed Rear: " + dq.removeLast());

        System.out.println("Deque after deletion: " + dq);

        // Check empty
        System.out.println("Is Empty? " + dq.isEmpty());

        // Check size
        System.out.println("Size: " + dq.size());
    }

}
