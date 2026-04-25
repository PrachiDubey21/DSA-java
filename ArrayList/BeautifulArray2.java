import java.util.ArrayList;

public class BeautifulArray2 {

    // Main function to generate beautiful array
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        divideConquer(1, 1, result, n); 
        return result;
    }

    // Divide & Conquer helper function
    private static void divideConquer(int start, int increment,
            ArrayList<Integer> result, int n) {

        // Base case
        if (start > n) {
            return;
        }

        // If only one number possible, add it
        if (start + increment > n) {
            result.add(start);
            return;
        }

        // First recursive call (larger gaps)
        divideConquer(start, increment * 2, result, n);

        // Second recursive call
        divideConquer(start + increment, increment * 2, result, n);
    }

    // Main method
    public static void main(String[] args) {
        int n = 5;
        ArrayList<Integer> ans = beautifulArray(n);
        System.out.println(ans);
    }
}
