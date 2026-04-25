import java.util.LinkedList;

public class stackusinglinkedlist {

    static class node {

        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class stack {

        static node head = null;

        // is empty
        public static boolean isempty() {
            return head == null;
        }

        // push
        public static void push(int data) {

            node newnode = new node(data);

            if (isempty()) {
                head = newnode;
                return;
            }

            newnode.next = head;
            head = newnode;
            return;

        }

        // pop
        public static int pop() {

            if (isempty()) {
                return Integer.MIN_VALUE;
            }

            int value = head.data;
            head = head.next;

            return value;
        }

        // peek
        public static int peek() {

            if (isempty()) {
                return Integer.MIN_VALUE;
            }

            int value = head.data;

            return value;
        }
    }

    public static void main(String[] args) {

        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println("poping the element : " + s.pop());
        System.out.println("the top element : " + s.peek());
        System.out.println();

        while (!s.isempty()) {

            System.out.println("the top element : " + s.peek());
            System.out.println("poping the element : " + s.pop());
            System.out.println();

        }
        System.out.println("---list is empty---");
        System.out.println();

    }

}
