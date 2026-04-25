import java.util.*;

public class ReverseKelementsOfQueue {

    static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < k; i++) {
            st.push(q.remove());
        }

        while (!st.isEmpty()) {
            q.add(st.pop());
        }

        int remaining = q.size() - k;
        for (int i = 0; i < remaining; i++) {
            q.add(q.remove());
        }

        return q;
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        int k = 3;

        Queue<Integer> result = reverseFirstK(q, k);
        System.out.println(result);
    }
}
