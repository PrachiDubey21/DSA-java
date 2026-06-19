import java.util.*;

public class InterpretetString {

    public static String interpret(String command) {

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {

            // G -> G
            if (command.charAt(i) == 'G') {
                ans.append("G");
            }

            // () -> o
            else if (command.charAt(i) == '(' &&
                     command.charAt(i + 1) == ')') {

                ans.append("o");
                i++; 
            }

            //  (al) -> al
            else if (command.charAt(i) == '(') {

                ans.append("al");
                i += 3; 
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String command = "G()(al)";

        String result = interpret(command);

        System.out.println("Input  : " + command);
        System.out.println("Output : " + result);

    }
    
}
