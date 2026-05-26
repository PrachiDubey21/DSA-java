import java.util.*;

public class PointsCount {

    public static int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for(String op : operations) {

            // remove previous score
            if(op.equals("C")) {
                stack.pop();
            }
            // double of previous score
            else if(op.equals("D")) {
                stack.push(stack.peek() * 2);
            }
            // sum 
            else if(op.equals("+")) {

                int top = stack.pop();
                int newScore = top + stack.peek();

                stack.push(top);
                stack.push(newScore);
            }
            else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;

        for(int score : stack) {
            sum += score;
        }

        return sum;
    }

    public static void main(String[] args) {

        String[] op = {"5","2","C","D","+"};

        int result = calPoints(op);
        System.out.println(result);

    }
    
}
