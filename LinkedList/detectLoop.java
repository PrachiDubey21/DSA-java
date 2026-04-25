public class detectLoop {

    public static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static node head;
    public static node tail;
    public static int size = 0;

    public static void addfirst(int data) {

        size++;
        node newnode = new node(data);

        if (head == null) {
            head = tail = newnode;
            return;
        }

        newnode.next = head;
        head = newnode;

    }

    public static void addlast(int data) {

        node newnode = new node(data);

        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }

        tail.next = newnode;
        tail = newnode;

    }

    public static void print(detectLoop ll) {

        if (head == null) {
            System.out.println("empty linked list");
            return;
        }

        node temp = head;

        System.out.println("---- linked list ---- ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null ");

    }

    public static void addinmiddle(int data, int index) {

        if (index == 0) {
            addfirst(data);
            return;
        }

        node newnode = new node(data);

        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }

        System.out.println();
        System.out.println("inserting : " + data + " at index : " + index);
        System.out.println();

        node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        newnode.next = temp.next;
        temp.next = newnode;

    }

    public static boolean detectLoop(node head) {

        node slow = head;
        node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeLoop(node head) {

        node slow = head;
        node fast = head;

        // Step 1: Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // loop detected
                break;
            }
        }

        // If no loop found
        if (fast == null || fast.next == null) {
            return;
        }

        // Step 2: Reset slow to head
        slow = head;

        // Case 1: Loop starts at head
        if (slow == fast) {
            // Move fast until fast.next == slow (last node in loop)
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null; // remove loop
            return;
        }

        // Case 2: Loop starts in middle
        node prev = null; // previous of fast

        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        // Step 3: Remove loop
        prev.next = null;
    }

    public static void main(String[] args) {

        detectLoop ll = new detectLoop();

        // ll.head = new node(10);
        // ll.head.next = new node(20);

        // ADD AT HEAD
        ll.addfirst(10);
        ll.addfirst(20);
        ll.addfirst(30);

        // ADD AT TAIL
        ll.addlast(50);
        ll.addlast(60);
        ll.addlast(40);

        // print
        System.out.println();
        print(ll);

        // ADD IN MIDDLE
        ll.addinmiddle(78, 3);
        print(ll);

        // size of
        System.out.println();
        System.out.println("size of linked list is " + size);

        // detect loop
        System.out.println(" the linked list has loop : " + detectLoop(head));

        // remove loop
        node head1 = new node(1);
        head1.next = new node(2);
        head1.next.next = new node(4);
        head1.next.next.next = head1;
        System.out.println();
        System.out.println(" the linked list has loop : " + detectLoop(head1));
        removeLoop(head1);
        System.out.println(" the linked list has loop : " + detectLoop(head1));

    }

}
