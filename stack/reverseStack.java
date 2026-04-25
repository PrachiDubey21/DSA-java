import java.util.Stack;

public class reverseStack {

    public static void pushAtBottom(Stack<Integer> s, int data) {

        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);

    }

    public static void reverse(Stack<Integer> s) {

        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverse(s);
        pushAtBottom(s, top);

    }

    public static void print(Stack<Integer> s) {

        if (s.isEmpty())
            return;

        int top = s.pop();
        System.out.println(top);

        print(s); // print remaining stack

        s.push(top); // restore element back
    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack();

        s.push(3);
        s.push(4);
        s.push(5);

        print(s);
        System.out.println();

        reverse(s);
        
        print(s);
        System.out.println();

    }

}
