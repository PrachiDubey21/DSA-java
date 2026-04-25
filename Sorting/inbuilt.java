import java.util.Arrays;
import java.util.Collections;

public class inbuilt {

    // o(n logn)

    public static void print(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void print(Integer arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = { 5, 4, 3, 2, 1, 12, 34, 3, 4, 5, 7, 9 };

        System.out.println();
        System.out.println("Before sorting : ");
        print(arr);

        Arrays.sort(arr);

        System.out.println();
        System.out.println("after sorting : ");
        print(arr);

        int brr[] = { 2, -14, 16, 12, -9, 57, 14 };

        System.out.println();
        System.out.println("Before sorting : ");
        print(brr);

        Arrays.sort(brr, 0, 4);

        System.out.println();
        System.out.println("after sorting : ");
        print(brr);

        Integer crr[] = { -34, -12, 21, 43, 65, 87, 90 };

        System.out.println();
        System.out.println("Before sorting : ");
        print(crr);

        //uses comparator
        // Arrays.sort(crr , Collections.reverseOrder());
        Arrays.sort(crr, 0, 4, Collections.reverseOrder());

        System.out.println();
        System.out.println("after sorting : ");
        print(crr);

    }
}
