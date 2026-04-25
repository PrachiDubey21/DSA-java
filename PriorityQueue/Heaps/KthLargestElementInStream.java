import java.util.*;;

public class KthLargestElementInStream {

    public static void kthLargest(int[] stream, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : stream) {

            minHeap.add(num);

            // Keep only k elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            // Output
            if (minHeap.size() < k) {
                System.out.print("_ ");
            } else {
                System.out.print(minHeap.peek() + " ");
            }
        }
    }

    public static void main(String[] args) {

        int[] stream = { 10, 20, 11, 70, 50, 40, 100, 5 };
        int k = 3;

        kthLargest(stream, k);
    }

}
