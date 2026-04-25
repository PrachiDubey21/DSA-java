import java.util.*;

public class removeDuplicate {

    public static String removeDuplicateLetters(String s) {

        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];

        // Step 1: Store last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();

        // Step 2: Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If character already used → skip
            if (visited[ch - 'a']) {
                continue;
            }

            // Step 3: Maintain lexicographically smallest order
            while (!st.isEmpty() && ch < st.peek() &&
                    lastIndex[st.peek() - 'a'] > i) {

                char removed = st.pop(); // pop large chars that appear later
                visited[removed - 'a'] = false;
            }

            // Step 4: Push current character
            st.push(ch);
            visited[ch - 'a'] = true;
        }

        // Step 5: Build final string from stack
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString(); // reverse to get correct order
    }

    // MAIN FUNCTION
    public static void main(String[] args) {

        // Test input
        String s = "cbacdcbc";

        // Call function
        String result = removeDuplicateLetters(s);

        // Output
        System.out.println("Output: " + result);
    }

}
