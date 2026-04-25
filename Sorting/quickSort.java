public class quickSort {

    // QuickSort function
    public static void quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        // Partition → returns correct position of pivot
        int pivotIndex = partition(arr, start, end);

        // Sort left part
        quickSort(arr, start, pivotIndex - 1);

        // Sort right part
        quickSort(arr, pivotIndex + 1, end);
    }

    // Partition function (Lomuto Partition scheme)
    public static int partition(int[] arr, int start, int end) {

        int pivot = arr[end]; // pivot = last element
        int i = start - 1; // correct place for smaller elements

        for (int j = start; j < end; j++) {

            // If element is smaller than pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot between smaller and larger elements
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1; // pivot index
    }

    public static void main(String[] args) {

        //worst case occurs when the pivot element
        //is alaways the smallest and largest 0(n2)

        int[] arr = { 5, 3, 8, 6, 2, 7 };

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
