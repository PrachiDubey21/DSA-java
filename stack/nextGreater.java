import java.util.Stack;

public class nextGreater {

    public static void find(int arr[], int next[], Stack<Integer> s) {

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                next[i] = -1;
            } else {
                next[i] = arr[s.peek()];
            }

            // we are pushing the index
            s.push(i);
        }

    }

    public static void main(String[] args) {

        int arr[] = { 6, 8, 0, 1, 3 };
        Stack<Integer> s = new Stack<>();
        int nextgreater[] = new int[arr.length];

        find(arr, nextgreater, s);

        System.out.println();

        for (int i = 0; i < nextgreater.length; i++) {
            System.out.print(nextgreater[i] + "  ");
        }

        System.out.println();
        
        //for next smaller left
        //reverse loop and inner condition

        //for next smaller right
        //reverse condition

        //for next greater left
        //reverse loop

    }

}
