import java.util.*;

public class MinAbsoluteDifference {

    public static void main(String[] args) {

        // o(n logn)

        int a[] = { 1, 2, 3 };
        int b[] = { 2, 1, 3 };

        Arrays.sort(a);
        Arrays.sort(b);

        int min = 0;
        for (int i = 0; i < a.length; i++) {
            min = min + Math.abs(a[i] - b[i]);
        }

        System.out.println("the min absolute diff is : " + min);

    }

}
