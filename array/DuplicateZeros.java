import java.util.*;

public class DuplicateZeros{

    public static void duplicatezero(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {

                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }

                if (i < arr.length - 1) {
                    arr[++i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};

        duplicatezero(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}