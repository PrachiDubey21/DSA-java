import java.util.*;

public class Pairs {

    public static void pairsinarray(int arr[]){

        System.out.println("pairs are : ");
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        int arr[] = new int[n];
        {

            System.out.println("Enter " + n + " elements : ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();

            }

            pairsinarray(arr);
        }

    }
}
