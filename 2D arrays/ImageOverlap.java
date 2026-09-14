import java.util.*;

public class ImageOverlap{

    public static int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;
        int ans = 0;

        for (int rowmove = -(n - 1); rowmove <= n - 1; rowmove++) {

            for (int colmove = -(n - 1); colmove <= n - 1; colmove++) {

                int count = 0;

                for (int i = 0; i < n; i++) {

                    for (int j = 0; j < n; j++) {

                        if (img1[i][j] == 1) {

                            int newrow = i + rowmove;
                            int newcol = j + colmove;

                            if (newrow >= 0 && newcol >= 0 &&
                                newrow < n && newcol < n) {

                                if (img2[newrow][newcol] == 1) {
                                    count++;
                                }
                            }
                        }
                    }
                }

                ans = Math.max(ans, count);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] img1 = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 1, 0}
        };

        int[][] img2 = {
            {0, 0, 0},
            {0, 1, 1},
            {0, 0, 1}
        };

        int result = largestOverlap(img1, img2);
        System.out.println("Maximum overlap = " + result);
        
    }
}