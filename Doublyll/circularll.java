public class circularll {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node head = null;
    public static Node tail = null;
    public static int size = 0;

    // ADD FIRST
    public static void addFirst(int data) {

        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            tail.next = head; // circular link
            return;
        }

        newNode.next = head;
        head = newNode;
        tail.next = head; // maintain circularity
    }

    // ADD LAST
    public static void addLast(int data) {

        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        tail.next = head; // circular link
    }

    // PRINT LIST
    public static void print() {

        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        System.out.println("---- Circular SLL ----");

        Node temp = head;

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(head)");
    }

    // ADD IN MIDDLE (index)
    public static void addInMiddle(int data, int index) {

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;

        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // REMOVE FIRST
    public static int removeFirst() {

        if (head == null) {
            System.out.println("Empty");
            return Integer.MIN_VALUE;
        }

        size--;

        int val = head.data;

        if (head == tail) { // only 1 node
            head = tail = null;
            return val;
        }

        head = head.next;
        tail.next = head; // maintain circularity

        return val;
    }

    // REMOVE LAST
    public static int removeLast() {

        if (head == null) {
            System.out.println("Empty");
            return Integer.MIN_VALUE;
        }

        size--;

        int val = tail.data;

        if (head == tail) { // only 1 node
            head = tail = null;
            return val;
        }

        Node temp = head;

        // move to 2nd last node
        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = head; // circular link
        tail = temp;

        return val;
    }

    // REVERSE SINGLE CIRCULAR SLL
    public static void reverse() {

        if (head == null || head == tail)
            return;

        Node prev = tail; // important change from normal SLL
        Node curr = head;
        Node next;

        do {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        } while (curr != head);

        // update head and tail
        tail = head;
        head = prev;
    }

    public static void main(String[] args) {

         circularll cll = new circularll();

        cll.addLast(10);
        cll.addLast(20);
        cll.addLast(30);
        cll.addLast(40);
        cll.addLast(50);
        cll.addLast(60);

        cll.print();

        cll.reverse();
        cll.print();

    }

}
