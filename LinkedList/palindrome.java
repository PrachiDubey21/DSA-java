public class palindrome {

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

    public static void print(palindrome ll) {

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
        node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean pali() {

        if (head == null || head.next == null) {
            return true;
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

        // compare
        node right = prev; // head node of 2nd half
        node left = head;

        while (right != null) {

            if (left.data != right.data) {
                return false;
            }

            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {

        palindrome ll = new palindrome();

        // ll.head = new node(10);
        // ll.head.next = new node(20);

        // ADD AT HEAD
        ll.addfirst(30);
        ll.addfirst(20);
        ll.addfirst(10);

        // ADD AT TAIL
        ll.addlast(30);
        ll.addlast(20);
        ll.addlast(10);

        // print
        System.out.println();
        print(ll);

        // ADD IN MIDDLE
        ll.addinmiddle(78, 3);
        print(ll);

        // size of
        System.out.println();
        System.out.println("size of linked list is " + size);

        // palindrome

        // approach 1
        // store elements in array and check if array is palindrome or not

        // approach 2 using constant space
        // find mid
        // reverse 2nd half
        // check if 1st half == 2nd half

        // to find mid use slow fast approach
        // for even till fast == null so slow is middle
        // for odd till fast.next == null
        System.out.println(pali());
    }

}
