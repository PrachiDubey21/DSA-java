public class FloodFill {

    public static void helper(int[][] i, int r, int col, int c, boolean[][] v, int orgcol) {

        // base case
        if (r < 0 || col < 0 || r >= i.length || col >= i[0].length
                || v[r][col] || i[r][col] != orgcol) {
            return;
        }

        // mark visited
        v[r][col] = true;

        // add colour
        i[r][col] = c;

        // left
        helper(i, r, col - 1, c, v, orgcol);

        // right
        helper(i, r, col + 1, c, v, orgcol);

        // up
        helper(i, r - 1, col, c, v, orgcol);

        // down
        helper(i, r + 1, col, c, v, orgcol);

    }

    public static int[][] floodfill(int[][] image, int sr, int sc, int color) {

        boolean vis[][] = new boolean[image.length][image[0].length];

        helper(image, sr, sc, color, vis, image[sr][sc]);

        return image;

    }

    public static void main(String[] args) {

        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };

        int sr = 1; // starting row
        int sc = 1; // starting column
        int color = 2; // new color

        int[][] result = floodfill(image, sr, sc, color);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}
