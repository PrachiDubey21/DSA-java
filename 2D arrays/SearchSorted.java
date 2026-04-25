public class SearchSorted {

    public static int Search(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0;
        int end = row * col - 1;

        int mid = start + (end - start) / 2;

        while (start <= end) {
            int element = matrix[mid / col][mid % col];
            if (element == target) {
                return mid;
            }
            if (element < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;

        }
        return -1;

    }

    public static void main(String[] args) {

        int arr[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int element = Search(arr, 20);
        if (element == -1) {
            System.out.println("element not found ");
        } else {

            int col = arr[0].length;
            int i = element / col;
            int j=element%col;
            System.out.println("element found at index [" + i + "][" + j + "] " );
        }

    }

}
