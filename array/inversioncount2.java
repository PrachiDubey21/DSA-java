public class inversioncount2 {

    // Use merge sort to divide the array into smaller parts.
    // While merging, whenever an element from the right half
    // is smaller than an
    // element from the left half, all remaining
    // elements in the left half form inversions.

    // Function to merge two halves and count inversions
    public static int merge(int arr[], int left, int mid, int right) {

        int i = left; // pointer for left half
        int j = mid + 1; // pointer for right half
        int k = 0; // pointer for temp array
        int invCount = 0;

        int temp[] = new int[right - left + 1];

        // Merge both halves while counting inversions
        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                // arr[i] > arr[j] → all elements from i to mid are inversions
                invCount += (mid - i + 1);
            }
        }

        // Copy remaining elements of left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right half
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy merged temp[] back to original arr[]
        k = 0;
        for (i = left; i <= right; i++) {
            arr[i] = temp[k++];
        }

        return invCount;
    }

    // Merge sort that also counts inversions
    private static int mergeSort(int arr[], int left, int right) {

        int invCount = 0;

        if (left < right) {

            int mid = (left + right) / 2;

            // Left half inversions
            invCount += mergeSort(arr, left, mid);

            // Right half inversions
            invCount += mergeSort(arr, mid + 1, right);

            // Merge and count split inversions
            invCount += merge(arr, left, mid, right);
        }

        return invCount;
    }

    // Function to call mergeSort
    public static int getInversions(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    // Main method
    public static void main(String args[]) {

        int arr[] = { 1, 20, 6, 4, 5 };

        int result = getInversions(arr);

        System.out.println("Inversion Count = " + result);
    }

}
