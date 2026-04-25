public class inversionCount {

    // An inversion means a pair (i, j) where:
    // i < j
    // arr[i] > arr[j]
    // This shows how far the array is from being sorted.

    // Example array: {1, 20, 6, 4, 5}
    // Inversions are:
    // 20 > 6
    // 20 > 4
    // 20 > 5
    // 6 > 4
    // 6 > 5
    // Total = 5 inversions

    public static int getInvCount(int arr[]) {
        int n = arr.length;
        int invCount = 0;

        // Count pairs (i, j) such that i < j and arr[i] > arr[j]
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    invCount++;
                }
            }
        }
        return invCount;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 20, 6, 4, 5 };
        System.out.println("Inversion Count = " + getInvCount(arr));
    }

}
