public class ZigZag {

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

    public static void print(ZigZag ll) {

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

    public static node middle() {

        node slow = head;
        node fast = head.next; // for last element to be middle in first node

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void zigzag() {

        if (head == null || head.next == null) {
            return;
        }

        // find mid
        node mid = middle();

        // reverse
        node prev = null;
        node curr = mid;

        while (curr != null) {
            node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // merge
        node left = head;
        node right = prev;
        node leftnext, rightnext;

        while (left != null && right != null) {

            //zig zag pattern
            leftnext = left.next;
            left.next = right;
            rightnext = right.next;
            right.next = leftnext;

            //update
            right = rightnext;
            left=leftnext;
        }
    }
 
    public static void main(String[] args) {

        ZigZag ll = new ZigZag();

        // ll.head = new node(10);
        // ll.head.next = new node(20);

        // ADD AT HEAD
        ll.addfirst(5);
        ll.addfirst(4);
        ll.addfirst(3);
        ll.addfirst(2);
        ll.addfirst(1);

        // print
        System.out.println();
        print(ll);

        zigzag();
        print(ll);

    }

}
