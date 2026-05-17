import java.util.*;

public class TransposeMatrix {

    public static int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] ans = new int[cols][rows];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                ans[j][i] = matrix[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] result = transpose(matrix);

        // print transpose matrix
        for(int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
    
}
