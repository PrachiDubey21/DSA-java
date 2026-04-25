import java.util.*;

public class BinarySearch {

    public static void sortArray(int arr[]){
        int n=arr.length;

         for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {

                // Compare adjacent elements
                if(arr[j] > arr[j+1]) {

                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2; // find middle index

            if (arr[mid] == target) {
                return mid; // element found
            }

            // if target is greater, ignore left half
            else if (arr[mid] < target) {
                start = mid + 1;
            }

            // if target is smaller, ignore right half
            else {
                end = mid - 1;
            }
        }

        return -1; // element not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int arr[] = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sortArray(arr);

        System.out.println("Sorted Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); 

        int key = 23;
        int index = binarySearch(arr, key);
        if (index == -1) {
            System.out.println("element not found");

        } else {
            System.out.println("element found at index : " + index);
        }

    }

}
