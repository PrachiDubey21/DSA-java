import java.util.*;

public class ReverseSignlyLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode smallhead = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return smallhead;
    }


    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("Original Linked List: ");
        printList(head);

        head = reverse(head);

        System.out.print("Reversed Linked List: ");
        printList(head);

    }
}
