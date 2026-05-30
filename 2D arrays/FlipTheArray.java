import java.util.*;

public class FlipTheArray {

    public static int[][] flipAndInvertImage(int[][] image) {

        int n = image.length;

        // Flip horizontally
        for(int i = 0; i < n; i++) {

            for(int j = 0, k = n - 1; j < k; j++, k--) {

                int temp = image[i][j];
                image[i][j] = image[i][k];
                image[i][k] = temp;
            }
        }

        // Invert the image
        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {

                if(image[i][j] == 0) {
                    image[i][j] = 1;
                }
                else {
                    image[i][j] = 0;
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {

        int[][] image = {
            {1, 1, 0},
            {1, 0, 1},
            {0, 0, 0}
        };

        int[][] result = flipAndInvertImage(image);

        System.out.println("Result Matrix:");

        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}