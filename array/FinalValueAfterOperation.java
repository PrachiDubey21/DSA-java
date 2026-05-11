import java.util.*;

public class FinalValueAfterOperation {

    public static void main(String[] args) {

        // Input operations
        String[] operations = {"--X", "X++", "X++"};

        // Initial value
        int x = 0;

        // Traverse operations
        for(int i = 0; i < operations.length; i++) {

            // Check increment
            if(operations[i].contains("++")) {

                x++;
            }
            else {

                x--;
            }
        }

        System.out.println("Final Value of X = " + x);
    }
    
}
