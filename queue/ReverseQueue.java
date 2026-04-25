import java.util.*;

public class ReverseQueue {

    // Function to reverse a queue
    public static void reverse(Queue<Integer> q) {

        Stack<Integer> stack = new Stack<>();

        // Step 1: Remove all elements from queue and push into stack
        while (!q.isEmpty()) {
            stack.push(q.remove());
        }

        // Step 2: Pop all elements from stack and add back to queue
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        // Adding values to queue
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        System.out.println("Original Queue: " + queue);

        reverse(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}

