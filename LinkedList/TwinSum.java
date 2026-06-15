import java.util.*;

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
    
}

public class TwinSum {

    public static int pairSum(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int maxSum = 0;

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {

            int sum = list.get(i) + list.get(j);

            if (sum > maxSum) {
                maxSum = sum;
            }

            i++;
            j--;
        }

        return maxSum;
    }

    public static void main(String[] args) {

        // 5 -> 4 -> 2 -> 1

        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        int ans = pairSum(head);

        System.out.println("Maximum Twin Sum = " + ans);
    }

}
