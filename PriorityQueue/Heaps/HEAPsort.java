public class HEAPsort {

    // Function to perform heap sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // STEP 1: Build Max Heap
        // Start from last non-leaf node
        for (int i = (n / 2) - 1 ; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // STEP 2: Extract elements from heap
        for (int i = n - 1; i > 0; i--) {

            // Swap root (largest) with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify root element with reduced heap size
            heapify(arr, i, 0);
        }
    }

    // Heapify function to maintain max heap property
    public static void heapify(int[] arr, int heapSize, int i) {

        int largest = i; // Assume root is largest
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If left child is larger than root
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {

            // Swap
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify affected subtree
            heapify(arr, heapSize, largest);
        }
    }

    // Main method to test heap sort
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        heapSort(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
