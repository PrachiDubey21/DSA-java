import java.util.*;

public class Shift2DGrid {

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;
        int total = rows * cols;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                int idx = i * cols + j;
                int newIdx = (idx + k) % total;

                int newRow = newIdx / cols;
                int newCol = newIdx % cols;

                result[newRow][newCol] = grid[i][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < rows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < cols; j++) {
                row.add(result[i][j]);
            }

            ans.add(row);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int k = 1;

        List<List<Integer>> result = shiftGrid(grid, k);
        System.out.println(result);

    }  
}