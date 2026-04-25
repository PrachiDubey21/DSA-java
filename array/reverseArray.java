import java.util.*;

public class reverseArray {

    public static void ReverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // swap
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // change
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 6;
        int arr[] = new int[n];

        System.out.println("Enter " + n + " elements ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Before reverse: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        ReverseArray(arr);

        System.out.println("after reverse: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }

}
