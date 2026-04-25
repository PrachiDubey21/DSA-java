public class knighttour {

    // N = size of chessboard (8x8)
    // Knight must visit all 64 cells exactly once
    static int N = 8;

    // =====================================================================
    // FUNCTION: isSafe()
    // PURPOSE: Check whether the knight can move to position (x, y)
    // =====================================================================
    public static boolean isSafe(int x, int y, int sol[][]) {

        // CONDITION 1: x should be between 0 and 7 → inside board
        // CONDITION 2: y should be between 0 and 7 → inside board
        // CONDITION 3: sol[x][y] should be -1 → means cell is not visited yet
        return (x >= 0 && x < N &&
                y >= 0 && y < N &&
                sol[x][y] == -1);
    }

    // =====================================================================
    // FUNCTION: printSolution()
    // PURPOSE: Print the solution matrix showing move numbers
    // =====================================================================
    public static void printSolution(int sol[][]) {

        // Loop through each row
        for (int x = 0; x < N; x++) {

            // Loop through each column
            for (int y = 0; y < N; y++)

                // Print the move number stored in sol[x][y]
                System.out.print(sol[x][y] + " ");

            // After finishing a row, print a new line
            System.out.println();
        }
    }

    // =====================================================================
    // FUNCTION: solveKT()
    // PURPOSE: This sets up the board and starts the knight tour recursion
    // =====================================================================
    public static boolean solveKT() {

        // sol[][] = 8x8 matrix to store move number of knight
        // sol[i][j] = -1 means NOT VISITED
        int sol[][] = new int[8][8];

        // Initialize the whole board as unvisited (-1)
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        // -----------------------------------------------------------------
        // xMove[] and yMove[] store the 8 possible moves of the knight
        // Knight moves in L-shape:
        // (±2, ±1) or (±1, ±2)
        // -----------------------------------------------------------------
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        // Place knight at starting position (0,0)
        // Move index = 0 means first move
        sol[0][0] = 0;

        // Call the recursive function starting from (0,0)
        // move index = 1 because move 0 is already placed
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {

            // If recursion cannot find full tour
            System.out.println("Solution does not exist");
            return false;

        } else {

            // If solution found, print complete board
            printSolution(sol);
            return true;
        }
    }

    // =====================================================================
    // FUNCTION: solveKTUtil()
    // PURPOSE: This is the backtracking function that builds the solution
    //
    // PARAMETERS:
    // x, y → current position of knight
    // movei → current move number (0 to 63)
    // sol[][] → solution board storing moves
    // xMove[] → possible x directions for knight
    // yMove[] → possible y directions for knight
    // =====================================================================
    public static boolean solveKTUtil(int x, int y,
            int movei,
            int sol[][],
            int xMove[],
            int yMove[]) {

        // k = loop counter for trying 8 directions
        int k;

        // next_x, next_y store new position of knight
        int next_x, next_y;

        // -----------------------------------------------------------------
        // BASE CASE:
        // If movei == 64 → knight has visited all cells
        // N*N = 8*8 = 64
        // -----------------------------------------------------------------
        if (movei == N * N)
            return true;

        // -----------------------------------------------------------------
        // Try all 8 possible knight moves from current (x,y)
        // -----------------------------------------------------------------
        for (k = 0; k < 8; k++) {

            // Calculate next possible x and y
            next_x = x + xMove[k];
            next_y = y + yMove[k];

            // Check if knight can move to this new position
            if (isSafe(next_x, next_y, sol)) {

                // Assign move number to this new cell
                sol[next_x][next_y] = movei;

                // Recursively try to place remaining moves
                if (solveKTUtil(next_x, next_y,
                        movei + 1, sol, xMove, yMove))
                    return true; // If recursion success → no need to try others

                else {
                    // BACKTRACKING:
                    // If next move failed, reset the cell to -1 (unvisited)
                    sol[next_x][next_y] = -1;
                }
            }
        }

        // If none of the 8 moves work → return false
        return false;
    }

    // =====================================================================
    // MAIN METHOD
    // =====================================================================
    public static void main(String args[]) {

        // Start solving the Knight's Tour problem
        solveKT();
    }

}
