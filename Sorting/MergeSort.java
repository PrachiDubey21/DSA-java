public class MergeSort {

    // Function to perform merge sort
    public static void mergeSort(int[] arr, int start, int end) {

        // Base case: if one element, already sorted
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        // Sort left half
        mergeSort(arr, start, mid);

        // Sort right half
        mergeSort(arr, mid + 1, end);

        // Merge both halves
        // merge(arr, start, mid, end);
        merge2(arr, start, mid, end);
    }

    // Merge function
    public static void merge(int[] arr, int start, int mid, int end) {

        // Sizes of two halves
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        // Temporary arrays
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        // Copy data into temp arrays
        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[start + i];
        }

        for (int i = 0; i < rightSize; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0; // pointer for left
        int j = 0; // pointer for right
        int k = start; // pointer for main array

        // Merge both arrays until one is empty
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left
        while (i < leftSize) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of right
        while (j < rightSize) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void merge2(int[] arr, int start, int mid, int end) {

        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        // Merge both halves
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // Copy temp back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[start + x] = temp[x];
        }
    }

    // Main to test
    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 6, 2, 7 };

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
