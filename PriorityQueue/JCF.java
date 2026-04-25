import java.util.Comparator;
import java.util.PriorityQueue;

public  class JCF {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //by default the smallest element will given more priority 

        // Insert elements
        pq.add(20);
        pq.add(10);
        pq.add(30);
        pq.add(5);

        // Printing queue (not sorted)
        System.out.println("Priority Queue: " + pq);
        System.out.println();

        // Peek (smallest element)
        System.out.println("Peek: " + pq.peek());
        System.out.println();

        // Removing elements
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        System.out.println();
    }
}
