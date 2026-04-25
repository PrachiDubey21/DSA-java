public class MergeKSortedLists {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Merge TWO sorted linked lists using TWO separate ifs
    static Node mergeTwoLists(Node a, Node b) {

        Node dummy = new Node(-1);
        Node tail = dummy;

        while (a != null && b != null) {

            // Take node from list a
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
                tail = tail.next;
            }

            // Take node from list b
            else if (b.data < a.data) {
                tail.next = b;
                b = b.next;
                tail = tail.next;
            }
        }

        // Attach remaining nodes
        if (a != null)
            tail.next = a;
        if (b != null)
            tail.next = b;

        return dummy.next;
    }

    // Merge K sorted lists (simple one-by-one merge)
    static Node mergeKLists(Node[] lists, int k) {

        if (k == 0)
            return null;

        Node result = lists[0];

        for (int i = 1; i < k; i++) {
            result = mergeTwoLists(result, lists[i]);
        }

        return result;
    }

    // Print linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // MAIN FUNCTION
    public static void main(String[] args) {

        int k = 3;
        Node[] lists = new Node[k];

        // List 1: 1 -> 4 -> 7
        lists[0] = new Node(1);
        lists[0].next = new Node(4);
        lists[0].next.next = new Node(7);

        // List 2: 2 -> 5 -> 8
        lists[1] = new Node(2);
        lists[1].next = new Node(5);
        lists[1].next.next = new Node(8);

        // List 3: 3 -> 6 -> 9
        lists[2] = new Node(3);
        lists[2].next = new Node(6);
        lists[2].next.next = new Node(9);

        Node result = mergeKLists(lists, k);

        System.out.println("Merged Sorted Linked List:");
        printList(result);
    }
}
