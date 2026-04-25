import java.util.*;

public class StackUsingTwoQueue {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation (costly)
    public void push(int x) {

        // Step 1: Add new element to q2
        q2.add(x);

        // Step 2: Move everything from q1 -> q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation (simple)
    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.remove();
    }

    // Peek (Top element)
    public int peek() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // MAIN METHOD
    public static void main(String[] args) {
        StackUsingTwoQueue st = new StackUsingTwoQueue();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st.pop()); // 30
        System.out.println(st.peek()); // 20
        System.out.println(st.pop()); // 20
        System.out.println(st.pop()); // 10
    }

}
