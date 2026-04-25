public class arraySorted {

    public static boolean isSorted(int[] arr, int index) {

        if (index == arr.length - 1) {
            return true; // reached end → sorted
        }

        if (arr[index] > arr[index + 1]) {
            return false; // found wrong order
        }

        return isSorted(arr, index + 1); // check next pair
    }

    public static void main(String[] args) {
        
        int arr[] = {2,3,4,5,6};
        int brr[] = {3,4,7,6,5};

        System.out.println(isSorted(arr,0));
        System.out.println(isSorted(brr,0));

    }

}
