public class linkedlist {

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

    public static void print(linkedlist ll) {

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

    public static int removefirst() {

        if (size == 0) {
            System.out.println("already empty ");
            return Integer.MIN_VALUE;

        } else if (size == 1) {

            size--;
            int value = head.data;
            head = tail = null;
            return value;

        }

        // it is automatically deleted by garbage collector

        size--;
        int value = head.data;
        head = head.next;
        return value;

    }

    public static int removelast() {

        if (size == 0) {
            System.out.println("already empty ");
            return Integer.MIN_VALUE;

        } else if (size == 1) {

            size--;
            int value = head.data;
            head = tail = null;
            return value;

        }

        // it is automatically deleted by garbage collector

        size--;
        int value = tail.data;
        node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        return value;

    }

    public static int search(int key) {

        if (size == 0) {
            System.out.println("linked list is empty");
            return -1;
        }

        int i = 0;
        node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;

    }

    private static int search2(int key, node temp, int index) {

        if (size == 0) {
            System.out.println("linked list is empty");
            return -1;
        }

        if (temp == null) {
            return -1;
        }

        if (temp.data == key) {
            return index;
        }

        return search2(key, temp.next, index + 1);

    }

    public static void reverse(){

        node curr = head;
        node prev = null;
        tail=head;

        while(curr != null){

            node next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }

        head = prev;
    }
    

    public static void main(String[] args) {

        linkedlist ll = new linkedlist();

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

        // REMOVE

        // from head
        System.out.println();
        System.out.println("the value to be deleted is : " + ll.removefirst());
        print(ll);
        System.out.println("size of linked list is " + size);

        // from tail
        System.out.println();
        System.out.println("the value to be deleted is : " + ll.removelast());
        print(ll);
        System.out.println("size of linked list is " + size);

        // // search element
        // System.out.println();
        // int i = search(30);
        // if (i == -1) {
        // System.out.println("---data not found---");
        // } else {
        // System.out.println("--- data found at index : " + i + "----");
        // }

        // search element recursively
        System.out.println();
        int i = search2(50, head, 0);
        if (i == -1) {
            System.out.println("---data not found---");
        } else {
            System.out.println("--- data found at index : " + i + "----");
        }

        //reverse LinkedList
        System.out.println("reversed linked list ");
        print(ll);
        reverse();
        print(ll);

    }

}
