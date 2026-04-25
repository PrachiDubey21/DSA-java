import java.util.*;

public class GenerateBinaryNumber {

  
    static void generatePrintBinary(int n) {
        Queue<String> q = new LinkedList<String>();

        // Add first binary number
        q.add("1");
        int i=1;

       
        while (n-- > 0) {
            String s1 = q.peek();
            q.remove();
  
            System.out.println(i++ +  " -> " + s1);

            // Add next two binary numbers
            q.add(s1 + "0");
            q.add(s1 + "1");
        }

    }

  
    public static void main(String[] args) {

        int n = 10; 
        generatePrintBinary(n);

    }

}
