import java.util.ArrayList;

public class stackusingArraylist {

    static class stack {

        static ArrayList<Integer> list = new ArrayList<>();

        // is empty
        public static boolean isempty() {
            return list.size() == 0;
        }

        // push
        public static void push(int data) {
            list.addLast(data);
        }

        // pop
        public static int pop() {

            if (isempty()) {
                return -1;
            }

            int value = list.getLast();
            list.removeLast();
            return value;
        }

        // peek
        public static int peek() {

            if (isempty()) {
                return -1;
            }

            int value = list.getLast();
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
