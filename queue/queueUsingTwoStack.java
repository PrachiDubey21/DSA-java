import java.util.Stack;

public class queueUsingTwoStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue operation (costly)
    public void enqueue(int x) {

        // If S1 is empty, directly push
        if (s1.isEmpty()) {
            s1.push(x);
            return;
        }

        // Step 1: Move everything from S1 to S2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Step 2: Push new element to S1
        s1.push(x);

        // Step 3: Move everything back from S2 to S1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Dequeue - just pop from S1
    public int dequeue() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.pop();
    }

    // Peek - just peek from S1
    public int peek() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    // MAIN METHOD
    public static void main(String[] args) {
        queueUsingTwoStack q = new queueUsingTwoStack();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue()); // 10
        System.out.println(q.peek()); // 20
        System.out.println(q.dequeue()); // 20
        System.out.println(q.dequeue()); // 30
    }
}
