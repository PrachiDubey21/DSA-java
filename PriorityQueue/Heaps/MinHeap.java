import java.util.*;

public class MinHeap {

    ArrayList<Integer> heap;

    // Constructor
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Insert into Min Heap
    public void insert(int value) {

        // Step 1: Add value at the end
        heap.add(value);

        int childIndex = heap.size() - 1;

        // Step 2: Heapify Up
        while (childIndex > 0) {

            int parentIndex = (childIndex - 1) / 2;

            // If parent is already smaller, heap property satisfied
            if (heap.get(parentIndex) <= heap.get(childIndex)) {
                break;
            }

            // Swap parent and child
            int temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(childIndex));
            heap.set(childIndex, temp);

            // Move up
            childIndex = parentIndex;
        }
    }

    public int peek() {

        if (heap.size() == 0) {
            System.out.println("Heap is empty");
            return 0;
        }

        return heap.get(0);
    }

    public int remove() {


        if (heap.size() == 0) {
            System.out.println("Heap is empty");
            return -1;
        }

        // Step 1: Store minimum element
        int min = heap.get(0);

        // Step 2: Move last element to root
        int last = heap.get(heap.size() - 1);
        heap.set(0, last);

        // Step 3: Remove last element
        heap.remove(heap.size() - 1);

        // Call heapify from root
        heapifyDown(0);

        return min;
    }

      private void heapifyDown(int index) {

        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // Compare with left child
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        // Compare with right child
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        // if it is not chnaged oit will stay the same value as root
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // ---------------- SWAP FUNCTION ----------------
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public boolean isEmpty(){
        if(heap.size()==0){
            return true;
        }
        else{
            return false;
        }
    }


    // Print heap
    public void printHeap() {
        System.out.println(heap);
    }

    // Main function
    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap();

        minHeap.insert(2);
        minHeap.insert(10);
        minHeap.insert(30);
        minHeap.insert(5);

        minHeap.printHeap();
        System.out.println();

        System.out.println("Peek : " + minHeap.peek());
        System.out.println();

        while(!minHeap.isEmpty()){
            System.out.println("Peek : " + minHeap.peek());
            minHeap.remove();
        }
        System.out.println();
    }
}
