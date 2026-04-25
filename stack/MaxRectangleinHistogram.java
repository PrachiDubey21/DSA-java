import java.util.Stack;

public class MaxRectangleinHistogram {

    public static int maxArea(int h[]) {

        int maxarea = 0;

        // next smaller right
        int nsr[] = new int[h.length];

        Stack<Integer> s = new Stack<>();

        for (int i = h.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && h[i] <= h[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsr[i] = h.length;
            } else {
               nsr[i] = s.peek();
            }

            // we are pushing the index
            s.push(i);
        }

        // next smaller left
        int nsl[] = new int[h.length];

        s = new Stack<>();

        for (int i = 0; i < h.length; i++) {

            while (!s.isEmpty() && h[i] <= h[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
               nsl[i] = s.peek();
            }

            // we are pushing the index
            s.push(i);
        }

        for (int i = 0; i < h.length; i++) {

            int area = h[i] * (nsr[i] - nsl[i] - 1);

            if (area > maxarea) 
            {
                maxarea = area;
            }
        }

        return maxarea;
    }

    public static void main(String[] args) {

        int height[] = { 2, 1, 5, 6, 2, 3 };
        int ans = maxArea(height);
        System.out.println("the maxarea is : " + ans);

    }

}
