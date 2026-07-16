import java.util.*;

public class IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {

        int perimeter = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {

                    perimeter += 4;

                    if (j + 1 < cols && grid[i][j + 1] == 1) {
                        perimeter -= 2;
                    }

                    if (i + 1 < rows && grid[i + 1][j] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        System.out.println("Island Perimeter = " + islandPerimeter(grid));

    }
    
}
