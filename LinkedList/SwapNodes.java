class SwapNodes {

    // Node definition
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Function to swap nodes with keys x and y
    static Node swapNodes(Node head, int x, int y) {

        // If both keys are same, no swap needed
        if (x == y)
            return head;

        // Search for x (keep track of previous node)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of previous node)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, no swap
        if (currX == null || currY == null)
            return head;

        // If x is not head, link its previous to currY
        if (prevX != null)
            prevX.next = currY;
        else
            head = currY; // x was head

        // If y is not head, link its previous to currX
        if (prevY != null)
            prevY.next = currX;
        else
            head = currX; // y was head

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return head;
    }

    // Function to print the list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main function
    public static void main(String[] args) {

        // Creating list: 10 -> 15 -> 12 -> 13 -> 20 -> 14
        Node head = new Node(10);
        head.next = new Node(15);
        head.next.next = new Node(12);
        head.next.next.next = new Node(13);
        head.next.next.next.next = new Node(20);
        head.next.next.next.next.next = new Node(14);

        System.out.println("Before Swapping:");
        printList(head);

        // Swap nodes with keys 12 and 20
        head = swapNodes(head, 12, 20);

        System.out.println("After Swapping:");
        printList(head);
    }
}
