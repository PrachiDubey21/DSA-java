import java.util.*;

public class CountClosedIslands {

    static int n, m;

    static boolean dfs(int[][] grid, int i, int j) {

        // If out of bounds → touches boundary → not closed
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }

        // If water → safe
        if (grid[i][j] == 0) {
            return true;
        }

        // Mark visited
        grid[i][j] = 0;

        boolean up = dfs(grid, i - 1, j);
        boolean down = dfs(grid, i + 1, j);
        boolean left = dfs(grid, i, j - 1);
        boolean right = dfs(grid, i, j + 1);

        return up && down && left && right;
    }

    public static int countClosedIslands(int[][] grid) {

        n = grid.length;
        m = grid[0].length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {0,0,0,0,0,0,0,1},
            {0,1,1,1,1,0,0,1},
            {0,1,0,1,0,0,0,1},
            {0,1,1,1,1,0,1,0},
            {0,0,0,0,0,0,0,1}
        };

        System.out.println(countClosedIslands(grid)); // Output: 2
    }

}
