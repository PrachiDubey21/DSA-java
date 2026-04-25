import java.util.ArrayList;
import java.util.List;

public class BinaryString {

    public static int binaryStrings(int n) {
        if (n == 1)
            return 2;
        if (n == 2)
            return 3;

        // If a string ends with 0, the previous bit can be anything.
        int zero = binaryStrings(n - 1);

        // If a string ends with 1, the previous bit must be 0.
        int one = binaryStrings(n - 2);

        return zero + one;
    }

    public static void addString(int n, int lastplace, String str) {

        if (n == 0) {
            System.out.println(str);
            return;
        }

        addString(n - 1, 0, str + "0");
        if (lastplace == 0) {

            addString(n - 1, 1, str + "1");
        }

    }

    public static List<String> addStrings(int n, int lastDigit, String str, List<String> list) {

        if (n == 0) {
            list.add(str);
            return list;
        }

        // Always add '1'
        addStrings(n - 1, 1, str + "1", list);

        // Add '0' only if last digit was 1
        if (lastDigit == 1) {
            addStrings(n - 1, 0, str + "0", list);
        }

        return list; // return after exploring both branches
    }

    public static void main(String[] args) {

        // int n = 2; 
        // System.out.println("Number of valid binary strings = " + binaryStrings(n));

        // addString(5, 0, "");

        // List<String> ans = new ArrayList<>();
        // System.out.println(addStrings(3, 1, "", ans));
    }

}
