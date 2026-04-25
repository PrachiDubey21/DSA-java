import java.util.ArrayList;

public class monotonic {

    public static boolean isMonotonic(ArrayList<Integer> A) {

        boolean inc = true; // check increasing
        boolean dec = true; // check decreasing

        for (int i = 0; i < A.size() - 1; i++) {

            if (A.get(i) > A.get(i + 1)) {
                inc = false;
            }

            if (A.get(i) < A.get(i + 1)) {
                dec = false;
            }
        }

        return inc || dec;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        // Add test values
        list.add(1);
        list.add(2);
        list.add(9);
        list.add(3);

        // Call function
        boolean result = isMonotonic(list);

        System.out.println("Is the list monotonic? " + result);
    }
}
