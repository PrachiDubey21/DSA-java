import java.util.*;

public class SmallestSubSequenceOfDistinctChar {

    public static String SubSequence(String s) {

        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (visited[ch - 'a']) {
                continue;
            }

            while (!st.isEmpty()
                    && ch < st.peek()
                    && lastIndex[st.peek() - 'a'] > i) {

                char removed = st.pop();
                visited[removed - 'a'] = false;
            }

            st.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        String s = "cbacdcbc";

        String result = SubSequence(s);
        System.out.println("Result = " + result);

    }
    
}
