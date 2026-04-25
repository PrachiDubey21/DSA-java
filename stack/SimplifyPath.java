import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path) {

        // Stack to store valid directory names
        Stack<String> stack = new Stack<>();

        // Split the path using '/'
        String[] parts = path.split("/");

        // Traverse using normal for loop
        for (int i = 0; i < parts.length; i++) {

            String part = parts[i];

            // Ignore empty string and "."
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // ".." means go to parent directory
            if (part.equals("..")) {

                // Remove last directory if stack is not empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // Valid directory name
            else {
                stack.push(part);
            }
        }

        // Build the final path
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stack.size(); i++) {

            //only reads char from stack doesnot pop it as popping of element gives
            //reverse sequence
            result.append("/").append(stack.get(i));
        }

        // If no directory exists, return root "/"
        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }

    // Main method for testing
    public static void main(String[] args) {

        System.out.println(simplifyPath("/apnacollege/b/")); // /apnacollege
        System.out.println(simplifyPath("/a/.."));        // /
    }
}
