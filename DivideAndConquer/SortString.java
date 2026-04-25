public class SortString {

    // Function to apply merge sort on a String array
    public static String[] mergeSort(String[] arr, int lo, int hi) {

        // Base case: single element is already sorted
        if (lo == hi) {
            String[] A = { arr[lo] };
            return A;
        }

        int mid = lo + (hi - lo) / 2;

        // Sort left half
        String[] arr1 = mergeSort(arr, lo, mid);

        // Sort right half
        String[] arr2 = mergeSort(arr, mid + 1, hi);

        // Merge both halves
        String[] arr3 = merge(arr1, arr2);

        return arr3;
    }

    // Merge two sorted string arrays
    static String[] merge(String[] arr1, String[] arr2) {

        int m = arr1.length;
        int n = arr2.length;

        String[] arr3 = new String[m + n];

        int idx = 0;
        int i = 0; // pointer for arr1
        int j = 0; // pointer for arr2

        // Merge while both arrays have elements
        while (i < m && j < n) {
            if (isAlphabeticallySmaller(arr1[i], arr2[j])) {
                arr3[idx++] = arr1[i++];
            } else {
                arr3[idx++] = arr2[j++];
            }
        }

        // Remaining elements of arr1
        while (i < m) {
            arr3[idx++] = arr1[i++];
        }

        // Remaining elements of arr2
        while (j < n) {
            arr3[idx++] = arr2[j++];
        }

        return arr3;
    }

    // Return true if str1 comes before str2 alphabetically
    static boolean isAlphabeticallySmaller(String str1, String str2) {
        return str1.compareTo(str2) < 0;
    }

    // Driver code
    public static void main(String[] args) {
        String[] arr = { "sun", "earth", "mars", "mercury" };

        String[] sorted = mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }
}
