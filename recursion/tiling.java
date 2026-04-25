public class tiling {
     // Function to count ways to tile a 2xn board
    public static int tile(int n) {

        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }

        int vertical = tile(n-1);
        int horizontal = tile(n-2);

        // Recursive formula
        return vertical + horizontal;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(tile(n));  // Output: 5
    }
}
