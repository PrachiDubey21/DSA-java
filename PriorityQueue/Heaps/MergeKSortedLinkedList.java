import java.util.*;

public class MergeKSortedLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of each list
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode current = head;

        while (!minHeap.isEmpty()) {

            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return head.next;
    }

    // Helper to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        // List 1
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(7);

        // List 2
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(8);

        // List 3
        ListNode l3 = new ListNode(9);
        l3.next = new ListNode(10);
        l3.next.next = new ListNode(11);

        ListNode[] lists = {l1, l2, l3};

        ListNode result = mergeKLists(lists);

        printList(result);
    }

    
}
