public class RetainMDeleteN {

    // Node definition for singly linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to retain M nodes and delete next N nodes
    static Node retainMDeleteN(Node head, int m, int n) {

        // If list is empty or m is 0, nothing should be retained
        if (head == null || m == 0) {
            return null;
        }

        Node curr = head;  // Pointer to traverse the list

        while (curr != null) {

            // STEP 1: Retain M nodes
            // Move curr M-1 times (because curr is already at 1st node)
            for (int i = 1; i < m && curr != null; i++) {
                curr = curr.next;
            }

            // If we reached end while retaining, stop
            if (curr == null) {
                break;
            }

            // STEP 2: Delete next N nodes
            Node temp = curr.next;  // Start deleting from next node

            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;   // Skip N nodes
            }

            // Link retained part with the remaining list
            curr.next = temp;

            // Move curr to the next retained node
            curr = temp;
        }

        return head; // Return modified list
    }

    // Helper function to print linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main function
    public static void main(String[] args) {

        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        int m = 2, n = 2;

        System.out.println("Original List:");
        printList(head);

        head = retainMDeleteN(head, m, n);

        System.out.println("Modified List:");
        printList(head);
    }
}
