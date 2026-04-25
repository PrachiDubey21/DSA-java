public class Sudoku {

    public static boolean isSafe(int[][] board, int row, int col, int digit) {

        // col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        // row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }

        // grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solver(int[][] board, int row, int col) {

        // base case
        if (row == 9) {
            return true; // solved completely
        }

        // recursion
        int newrow = row;
        int newcol = col + 1;
        if (col == 8) {
            newrow = row + 1;
            newcol = 0;
        }

        if (board[row][col] != 0) {
            return solver(board, newrow, newcol);
        }

        for (int digits = 1; digits <= 9; digits++) {
            if (isSafe(board, row, col, digits)) {
                board[row][col] = digits;

                if (solver(board, newrow, newcol)) {
                    return true;
                }

            }
            board[row][col] = 0;
        }

        return false;
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] board = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };

        if (solver(board, 0, 0)) {
            System.out.println("Sudoku Solved Successfully!\n");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }

    }

}
