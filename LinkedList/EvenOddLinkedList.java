public class EvenOddLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to rearrange even before odd (stable order)
    public static Node rearrangeEvenOdd(Node head) {

        if (head == null)
            return null;

        Node evenDummy = new Node(-1);
        Node oddDummy = new Node(-1);

        Node evenTail = evenDummy;
        Node oddTail = oddDummy;

        Node curr = head;

        while (curr != null) {

            if (curr.data % 2 == 0) {
                evenTail.next = curr;
                evenTail = evenTail.next;
            } else {
                oddTail.next = curr;
                oddTail = oddTail.next;
            }

            curr = curr.next;
        }

        // Connect even list with odd list
        evenTail.next = oddDummy.next;
        oddTail.next = null;

        return evenDummy.next;
    }

    // Utility function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // MAIN FUNCTION
    public static void main(String[] args) {

        /*
         * Creating linked list:
         * 1 -> 2 -> 3 -> 4 -> 6 -> 5 -> null
         */

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        head = rearrangeEvenOdd(head);

        System.out.println("Modified Linked List (Even before Odd):");
        printList(head);
    }
}
