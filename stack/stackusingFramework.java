import java.util.*;

public class stackusingFramework {

    public static void main(String[] args){

        Stack <Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println("poping the element : " + s.pop());
        System.out.println("the top element : " + s.peek());
        System.out.println();

        while (!s.isEmpty()) {

            System.out.println("the top element : " + s.peek());
            System.out.println("poping the element : " + s.pop());
            System.out.println();

        }
        System.out.println("---list is empty---");
        System.out.println();

    }
    
}
