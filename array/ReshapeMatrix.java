import java.util.*;

public class ReshapeMatrix {

    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int rows = mat.length;
        int cols = mat[0].length;

        // if possible
        if(rows * cols != r * c) {
            return mat;
        }

        //reshaped matrix
        int[][] ans = new int[r][c];

        int row = 0;
        int col = 0;

        // traverse old matrix
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {

                ans[row][col] = mat[i][j];
                col++;

                // Move to next row if column becomes full
                if(col == c) {
                    col = 0;
                    row++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] mat = {
            {1, 2},
            {3, 4}
        };

        int r = 1;

        int c = 4;

        int[][] result = matrixReshape(mat, r, c);

        // Print reshaped matrix
        for(int i = 0; i < result.length; i++) {

            System.out.println(Arrays.toString(result[i]));
        }
    }
    
}
