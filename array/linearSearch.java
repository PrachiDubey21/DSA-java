
public class linearSearch {

    public static int linear(int arr[], int key) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {

        int arr[] = { 5, 9, 1, 78, 65, 23 };
        int key = 65;
        int i = linear(arr, key);
        if (i == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + i);
        }

    }
}
