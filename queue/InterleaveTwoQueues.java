
import java.util.*;

public class InterleaveTwoQueues {

    public static void interleave(Queue<Integer> q1) {

        int size = q1.size();

        if (size % 2 != 0) {
            System.out.println("Queue must have even number of elements");
            return;
        }

        Queue<Integer> q2 = new LinkedList<>();
        int half = size / 2;

        // Step 1: Move first half into q2
        for (int i = 0; i < half; i++) {
            q2.add(q1.remove());
        }

        // Step 2: Interleave q1 (second half) and q2 (first half)
        while (!q2.isEmpty()) {

            // Take from q2 (first half)
            q1.add(q2.remove());

            // Take from q1 (second half original front)
            q1.add(q1.remove());
        }
    }

    // MAIN
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        interleave(q);

        System.out.println(q); // Output: [1, 4, 2, 5, 3, 6]
    }
}
