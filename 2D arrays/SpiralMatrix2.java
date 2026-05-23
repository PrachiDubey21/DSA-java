import java.util.*;

public class SpiralMatrix2 {

    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n - 1;

        int left = 0;
        int right = n - 1;

        int num = 1;

        while (top <= bottom && left <= right) {

            // left to right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num;
                num++;
            }

            top++;

            // top to bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num;
                num++;
            }

            right--;

            // right to left
            if (top <= bottom) {

                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num;
                    num++;
                }

                bottom--;
            }

            // bottom to top
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num;
                    num++;
                }

                left++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] result = generateMatrix(n);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

}
