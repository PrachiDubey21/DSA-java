import java.util.*;

public class Subarrays {

    public static void Subarray(int arr[]) {

        System.out.println("subarrays are : ");

        for (int i = 0; i < arr.length; i++) {

            for (int j = i ; j < arr.length; j++) {

                System.out.print("( ");
                for (int k = i; k <= j; k++) {
                    System.out.print("|" + arr[k] + "|");
                }
                System.out.println(" )  ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 5;
        int arr[] = new int[n];

        System.out.println("Enter " + n + " elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }

        Subarray(arr);

    }
}