import java.util.*;

public class SizeOfLargestRegion {

    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static int largestRegion(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && !visited[i][j]) {

                    int size = dfs(grid, visited, i, j);
                    max = Math.max(max, size);
                }
            }
        }

        return max;
    }

    public static int dfs(int[][] grid, boolean[][] visited, int i, int j) {

        // mark visited
        visited[i][j] = true;

        int count = 1; // current cell

        // check all 8 directions
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {

                int ni = i + x;
                int nj = j + y;

                // skip itself (0,0)
                if (x == 0 && y == 0)
                    continue;

                // check valid + unvisited + 1
                if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length
                        && grid[ni][nj] == 1 && !visited[ni][nj]) {

                    count += dfs(grid, visited, ni, nj);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] grid = {
                { 0, 0, 1, 1, 0 },
                { 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 }
        };

        System.out.println(largestRegion(grid));
    }

}
