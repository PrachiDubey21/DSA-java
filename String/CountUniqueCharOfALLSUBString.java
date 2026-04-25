public class CountUniqueCharOfALLSUBString {

    public static int uniqueLetterString(String s) {

        int n = s.length();
        int result = 0;

        // Loop for each lowercase letter
        for (char ch = 'a'; ch <= 'z'; ch++) {

            int prev = -1; // previous occurrence index
            int curr = -1; // current occurrence index

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == ch) {

                    // Add contribution of previous occurrence
                    if (curr != -1) {
                        result += (curr - prev) * (i - curr);
                    }

                    prev = curr;
                    curr = i;
                }
            }

            // Add contribution of last occurrence
            if (curr != -1) {
                result += (curr - prev) * (n - curr);
            }
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        String s = "ababa";
        int answer = uniqueLetterString(s);

        System.out.println("String: " + s);
        System.out.println("Count of unique characters of all substrings: " + answer);
    }

}
