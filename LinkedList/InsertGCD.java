import java.util.*;

public class InsertGCD {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            int value = gcd(curr.val, curr.next.val);
            ListNode newNode = new ListNode(value);

            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        return head;
    }

    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);

        printList(head);
        System.out.println();
        head = insertGreatestCommonDivisors(head);
        printList(head);

    }
}