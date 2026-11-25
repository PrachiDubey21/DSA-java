import java.util.*;

public class MergeKSortedLists2 {

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

        for (ListNode node : lists) {

            while (node != null) {
                minHeap.add(node);
                node = node.next;
            }
        }

        ListNode head = new ListNode(0);
        ListNode current = head;

        while (!minHeap.isEmpty()) {

            ListNode smallest = minHeap.poll();

            current.next = smallest;
            current = current.next;
        }

        current.next = null;
        return head.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        ListNode result = mergeKLists(lists);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}