import java.util.*;

public class MinTimeToRotAllOranges {

    public static int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: find rotten + count fresh
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j}); // add rotten
                }

                if (grid[i][j] == 1) {
                    fresh++; // count fresh
                }
            }
        }

        int time = 0;

        // Step 2: BFS
        while (!q.isEmpty() && fresh > 0) {

            int size = q.size(); // process one level

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                // 4 directions

                // up
                if (r-1 >= 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    q.add(new int[]{r-1, c});
                    fresh--;
                }

                // down
                if (r+1 < n && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    q.add(new int[]{r+1, c});
                    fresh--;
                }

                // left
                if (c-1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    q.add(new int[]{r, c-1});
                    fresh--;
                }

                // right
                if (c+1 < m && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    q.add(new int[]{r, c+1});
                    fresh--;
                }
            }

            time++; // one minute passed
        }

        // Step 3: check
        if (fresh == 0) return time;
        else return -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {2,1,0,2,1},
            {0,0,1,2,1},
            {1,0,0,2,1}
        };

        System.out.println(orangesRotting(grid));
    }
    
}
