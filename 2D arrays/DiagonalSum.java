public class DiagonalSum {

    public static int diagonalSum(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            // Primary diagonal
            sum += matrix[i][i];

            // Secondary diagonal
            if(i!=n-1-i)
            sum += matrix[i][n - 1 - i];
        }

      

        return sum;
    }

    public static void main(String[] args) {
          int arr[][]={{1,2,3} , {4,5,6} , {7,8,9}};
        int sum=diagonalSum(arr);
        System.out.println("sum is " + sum);

    }

}
