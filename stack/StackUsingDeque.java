
import java.util.*;

public class StackUsingDeque {

    Deque<Integer> dq = new ArrayDeque<>();

    // push element (top is at rear)
    public void push(int x) {
        dq.addLast(x);
    }

    // pop element from top
    public int pop() {
        if (dq.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return dq.removeLast();
    }

    // peek top element
    public int peek() {
        if (dq.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return dq.peekLast();
    }

    // check empty
    public boolean isEmpty() {
        return dq.isEmpty();
    }

    // size
    public int size() {
        return dq.size();
    }

    public static void main(String[] args) {

        StackUsingDeque st = new StackUsingDeque();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Top element: " + st.peek());
        System.out.println("Popped: " + st.pop());
        System.out.println("Top after pop: " + st.peek());

        System.out.println("Is Empty? " + st.isEmpty());
        System.out.println("Size: " + st.size());
    }
}
