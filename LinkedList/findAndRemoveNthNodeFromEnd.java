public class findAndRemoveNthNodeFromEnd {

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

    public static void print(findAndRemoveNthNodeFromEnd ll) {

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

    public static void remove(int n){

        //size
        int size=0;
        node temp = head;

        while(temp != null){
            temp=temp.next;
            size++;
        }

        if(n==size){
            head = head.next;
            return;
        }

        int i=1;
        int itof = size-n;
        node prev = head;


        while(i < itof){
        
            prev = prev.next;
            i++;

        }

        prev.next = prev.next.next;
        return;
    }

    public static void main(String[] args) {

        findAndRemoveNthNodeFromEnd ll = new findAndRemoveNthNodeFromEnd();

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

        //nth node from end = size - n + 1 th node
        remove(3);
        print(ll);

    }

}
