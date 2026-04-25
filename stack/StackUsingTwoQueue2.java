import java.util.*;

public class StackUsingTwoQueue2 {

   
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push: always push to the non-empty queue
    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.add(x);
        } else {
            q2.add(x);
        }
    }

    // Pop: costly
    public int pop() {

        if (q1.isEmpty() && q2.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        // Case 1: If q1 has elements
        if (!q1.isEmpty()) {

            // Move all except last to q2
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            // Last element from q1 is the "top" of the stack
            return q1.remove();
        }

        // Case 2: If q2 has elements
        else {

            // Move all except last to q1
            while (q2.size() > 1) {
                q1.add(q2.remove());
            }

            // Last element from q2 is the "top"
            return q2.remove();
        }
    }

    // Peek: same logic as pop but without removing
    public int peek() {
        if (q1.isEmpty() && q2.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        int top;

        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            top = q1.remove();  // last element
            q2.add(top);        // put it back
        } else {
            while (q2.size() > 1) {
                q1.add(q2.remove());
            }
            top = q2.remove();
            q1.add(top);
        }

        return top;
    }

    public static void main(String[] args) {

    StackUsingTwoQueue2 st = new StackUsingTwoQueue2();

    // Push elements
    st.push(10);
    st.push(20);
    st.push(30);
    st.push(40);

    // Pop elements
    System.out.println(st.pop());  // 40
    System.out.println(st.peek()); // 30
    System.out.println(st.pop());  // 30
    System.out.println(st.pop());  // 20
    System.out.println(st.pop());  // 10

    // Try popping from empty stack
    System.out.println(st.pop());  // -1 (empty)
}
    
}
