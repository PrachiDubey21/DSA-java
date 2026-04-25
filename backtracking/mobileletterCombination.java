public class mobileletterCombination {

    // Mapping digits → letters (like mobile keypad)
    // L[2] = {a,b,c}, L[3] = {d,e,f}, etc.
    final static char[][] L = {
            {}, // 0 → no letters
            {}, // 1 → no letters
            { 'a', 'b', 'c' }, // 2
            { 'd', 'e', 'f' }, // 3
            { 'g', 'h', 'i' }, // 4
            { 'j', 'k', 'l' }, // 5
            { 'm', 'n', 'o' }, // 6
            { 'p', 'q', 'r', 's' }, // 7
            { 't', 'u', 'v' }, // 8
            { 'w', 'x', 'y', 'z' } // 9
    };

    // MAIN FUNCTION → accepts the digit string
    public static void letterCombinations(String D) {

        int len = D.length(); // Find length of input

        // If input is empty → no combinations possible
        if (len == 0) {
            System.out.println("");
            return;
        }

        // Start recursion from position 0 with empty string builder
        bfs(0, len, new StringBuilder(), D);
    }

    // Recursive function to generate combinations
    public static void bfs(int pos, int len, StringBuilder sb, String D) {

        // BASE CASE: if current index reached the end of digit string
        if (pos == len) {
            // Print the complete combination formed so far
            System.out.println(sb.toString());
            return;
        }

        // Convert current character (digit) to an integer
        int digit = Character.getNumericValue(D.charAt(pos));

        // Fetch all possible letters mapped to this digit
        char[] letters = L[digit];

        // Loop through each possible letter
        for (int i = 0; i < letters.length; i++) {

            // Create a new StringBuilder to avoid overwriting old one
            // Add the current letter to partial combination
            StringBuilder newSB = new StringBuilder(sb).append(letters[i]);

            // Move to the next digit (pos + 1)
            bfs(pos + 1, len, newSB, D);
        }
    }

    // MAIN METHOD
    public static void main(String args[]) {

        // Example input: prints a, b, c
        letterCombinations("23");
    }

}
