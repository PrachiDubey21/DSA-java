import java.util.Scanner;

public class BinarySearchRecursively {

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

    public static int binarysearch(int arr[], int start, int end, int key) {
        int mid = start + (end - start) / 2;
        if (start > end)
            return -1;

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[mid] < key) {
            return binarysearch(arr, mid + 1, end, key);
        } else {
            return binarysearch(arr, start, mid - 1, key);
        }
    }

public static void main(String[] args)
{

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

        int key=20;

    int index = binarysearch(arr, 0, n - 1, key);
    if (index == -1) {
            System.out.println("element not found");

        } else {
            System.out.println("element found at index : " + index);
        }
}
}
