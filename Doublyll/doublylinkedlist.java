import org.w3c.dom.Node;

public class doublylinkedlist {

    public static class node {
        int data;
        node next;
        node prev;

        public node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static node head;
    public static node tail;
    public static int size = 0;

    // ADD FIRST
    public static void addFirst(int data) {

        node newNode = new node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public static void addLast(int data) {

        node newNode = new node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // PRINT
    public static void print() {

        if (head == null) {
            System.out.println("empty linked list");
            return;
        }

        System.out.println("---- linked list (forward) ----");
        node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ADD IN MIDDLE
    public static void addInMiddle(int data, int index) {

        if (index == 0) {
            addFirst(data);
            return;
        }

        node newNode = new node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        System.out.println("\nInserting: " + data + " at index: " + index + "\n");

        node temp = head;
        int i = 0;

        while (i < index - 1 && temp != null) {
            temp = temp.next;
            i++;
        }

        // insert between temp and temp.next
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode; // inserted at last
        }

        temp.next = newNode;
    }

    // REMOVE FIRST
    public static int removeFirst() {

        if (size == 0) {
            System.out.println("already empty");
            return Integer.MIN_VALUE;
        }

        int value = head.data;

        if (size == 1) {
            head = tail = null;
            size--;
            return value;
        }

        head = head.next;
        head.prev = null;
        size--;
        return value;
    }

    // REMOVE LAST
    public static int removeLast() {

        if (size == 0) {
            System.out.println("already empty");
            return Integer.MIN_VALUE;
        }

        int value = tail.data;

        if (size == 1) {
            head = tail = null;
            size--;
            return value;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
        return value;
    }

   public static void reverse(){

        node curr = head;
        node prev = null;
        tail=head;

        while(curr != null){

            node next = curr.next;
            curr.next=prev;
            curr.prev = next;
            
            prev=curr;
            curr=next;

        }

        head = prev;
    }
    public static void main(String[] args) {

        doublylinkedlist dll = new doublylinkedlist();

        dll.addLast(10);
        dll.addLast(20);
        dll.addLast(30);
        dll.addLast(40);
        dll.addLast(50);
        dll.addLast(60);

        dll.print();

        dll.reverse();
        dll.print();

    }

}
