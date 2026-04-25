import java.util.Stack;

public class queueUsingtwoStack2 {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Add element to queue
    public void enqueue(int x) {
        s1.push(x);
    }

    // Remove element from queue (front)
    public int dequeue() {
        // If both stacks empty → queue is empty
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // If s2 is empty, move all elements from s1 to s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        // Now top of s2 is the front of queue
        return s2.pop();
    }

    // Peek front element
    public int peek() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // MAIN METHOD
    public static void main(String[] args) {
        queueUsingtwoStack2 q = new queueUsingtwoStack2();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue()); // 10
        System.out.println(q.peek()); // 20
        System.out.println(q.dequeue()); // 20
        System.out.println(q.dequeue()); // 30
        System.out.println(q.dequeue()); // empty
    }

}
