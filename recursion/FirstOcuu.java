public class FirstOcuu {

    public static int firstOccurrence(int[] arr, int index, int target) {

        if (index == arr.length) {
            return -1; // not found
        }

        if (arr[index] == target) {
            return index; // found
        }

        return firstOccurrence(arr, index + 1, target);
    }

    public static int LastOccurrence(int[] arr, int index, int target) {

        if (index == arr.length) {
            return -1; // not found
        }

        if (arr[index] == target) {
            return index; // found
        }

        return LastOccurrence(arr, index - 1, target);
    }

    public static void main(String[] args) {

        int[] arr = { 5, 3, 7, 3, 9, 7 };
        System.out.println(firstOccurrence(arr, 0, 3));

        int n = arr.length;
        // System.out.println(n);
        System.out.println(LastOccurrence(arr, n - 1, 3));

    }
}
