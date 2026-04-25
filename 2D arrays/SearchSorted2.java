public class SearchSorted2 {

    public static int[] Search(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;
        int rindex = 0;
        int colindex = col - 1;

        while (rindex < row && colindex >= 0) {
            int element = matrix[rindex][colindex];

            if (element == target) {
               return new int[]{rindex, colindex};
            }
            if (element < target) {
                rindex++;
            }

            else {
                colindex--;
            }
        }
        return new int[]{-1, -1}; 

    }

    public static void main(String[] args) {

        int arr[][] = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };

        int result[] = Search(arr, 30);
        if (result[0] == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index [" + result[0] + "][" + result[1] + "]");
        }

    }

}
