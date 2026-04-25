import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {

        // Stack to store repeat counts
        Stack<Integer> countStack = new Stack<>();

        // Stack to store previous strings
        Stack<String> stringStack = new Stack<>();

        // Current decoded string
        String currentString = "";

        // Number before '['
        int number = 0;

        // Traverse the string character by character
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If character is a digit
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            // If '[' is found
            else if (ch == '[') {

                // Save current state
                countStack.push(number);
                stringStack.push(currentString);

                // Reset values
                number = 0;
                currentString = "";
            }

            // If ']' is found
            else if (ch == ']') {

                // Get repeat count
                int repeatCount = countStack.pop();

                // Get previous string
                String previousString = stringStack.pop();

                // Repeat current string
                StringBuilder temp = new StringBuilder(previousString);

                for (int j = 0; j < repeatCount; j++) {
                    temp.append(currentString);
                }

                currentString = temp.toString();
            }

            // If normal character
            else {
                currentString = currentString + ch;
            }
        }

        // Final decoded string
        return currentString;
    }

    public static void main(String[] args) {

        System.out.println(decodeString("2[cv]"));      // cvcv
        System.out.println(decodeString("3[b2[v]]"));   // bvvbvvbvv
    }
}
