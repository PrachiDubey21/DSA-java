class mergesort {

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

    public static void print(mergesort ll) {

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

    public static node mid(node head) {

        node slow = head;
        node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static node merge(node head1, node head2) {

        node mergedll = new node(-1);
        node temp = mergedll;

        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;

            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }

        }

        while (head1 != null) {

            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;

        }

        while (head2 != null) {

            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;

        }

        return mergedll.next;
    }

    public static node mergesort(node head) {

        if (head == null || head.next == null) {
            return head;

        }

        // find mid
        node mid = mid(head);

        // divide
        node righthead = mid.next;
        mid.next = null;

        // call
        node newleft = mergesort(head);
        node newright = mergesort(righthead);

        // merge
        return merge(newleft, newright);

    }

    public static void main(String[] args) {

        mergesort ll = new mergesort();

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

        //mergesort
        head = mergesort(head);
        print(ll);
    }

}
