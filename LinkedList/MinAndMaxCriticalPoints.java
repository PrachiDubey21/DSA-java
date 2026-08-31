public class MinAndMaxCriticalPoints {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode nextt = curr.next;

        int first = -1;
        int last = -1;
        int min = Integer.MAX_VALUE;

        int count = 2;

        while (nextt != null) {

            boolean maximum = curr.val > prev.val && curr.val > nextt.val;
            boolean minimum = curr.val < prev.val && curr.val < nextt.val;

            if (maximum || minimum) {

                if (first == -1) {
                    first = count;
                }

                if (last != -1) {
                    min = Math.min(min, count - last);
                }

                last = count;
            }

            count++;
            prev = curr;
            curr = nextt;
            nextt = nextt.next;
        }

        if (first == last) {
            return new int[]{-1, -1};
        }

        int max = last - first;

        return new int[]{min, max};
    }

    public static void main(String[] args) {

        // 1 → 5 → 3 → 7 → 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(2);

        int[] result = nodesBetweenCriticalPoints(head);

        System.out.println("Minimum distance: " + result[0]);
        System.out.println("Maximum distance: " + result[1]);
    }
}