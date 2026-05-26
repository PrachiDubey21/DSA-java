import java.util.*;

public class JumpGame7 {

    public static boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        int farthest = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            // check from new unvisited range only
            int start = Math.max(current + minJump, farthest + 1);

            // Maximum possible jump
            int end = Math.min(current + maxJump, n - 1);

            for (int i = start; i <= end; i++) {

                // jump only on '0'
                if (s.charAt(i) == '0' && !visited[i]) {

                    // If last index reached
                    if (i == n - 1) {
                        return true;
                    }

                    visited[i] = true;

                    queue.add(i);
                }
            }

            farthest = end;
        }

        return n == 1;
    }

    public static void main(String[] args) {

        String s = "011010";

        int minJump = 2;
        int maxJump = 3;

        boolean result = canReach(s, minJump, maxJump);
        System.out.println(result);

    }

}
