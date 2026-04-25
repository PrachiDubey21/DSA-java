import java.util.*;

public class MinOperationToHalfArraySum {

    public static int minOperations(int[] arr) {

        PriorityQueue<Double> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        double sum = 0;

        // Add elements
        for (int num : arr) {
            maxHeap.add((double) num);
            sum += num;
        }

        double target = sum / 2;
        int operations = 0;

        while (sum > target) {

            double largest = maxHeap.poll();

            double half = largest / 2;

            sum -= (largest - half);

            maxHeap.add(half);

            operations++;
        }

        return operations;
    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 8, 19};

        System.out.println("Minimum Operations: " + minOperations(arr));
    }

    
}
