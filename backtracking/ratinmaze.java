public class ratinmaze {

    // Function to print the solution matrix
    public static void printSolution(int sol[][]) {

        // Loop through rows
        for (int i = 0; i < sol.length; i++) {

            // Loop through columns
            for (int j = 0; j < sol.length; j++) {

                // Print each cell of solution matrix
                System.out.print(" " + sol[i][j] + " ");
            }

            // Move to next line
            System.out.println();
        }
    }

    // Function to check if (row, col) is valid and safe
    public static boolean isSafe(int maze[][], int row, int col) {

        // A position is safe if:
        // 1. row is within 0 to N-1
        // 2. col is within 0 to N-1
        // 3. maze[row][col] == 1 (open path)
        return (row >= 0 && row < maze.length &&
                col >= 0 && col < maze.length &&
                maze[row][col] == 1);
    }

    // Solve the maze starting from (0,0)
    public static boolean solveMaze(int maze[][]) {

        int N = maze.length; // Maze size
        int sol[][] = new int[N][N]; // Solution matrix with all 0s

        // Call recursive function
        if (solveMazeUtil(maze, 0, 0, sol) == false) {

            System.out.println("Solution doesn't exist");
            return false;
        }

        // Print solution if path is found
        printSolution(sol);
        return true;
    }

    // Recursive function to explore path
    public static boolean solveMazeUtil(int maze[][], int row, int col, int sol[][]) {

        // STEP 1: Base Case → If we have reached bottom-right cell
        if (row == maze.length - 1 && col == maze.length - 1 && maze[row][col] == 1) {

            sol[row][col] = 1; // Mark goal cell as part of the solution path
            return true;
        }

        // STEP 2: Check if current cell is safe
        if (isSafe(maze, row, col)) {

            // Avoid looping by checking if this cell is already part of solution
            if (sol[row][col] == 1)
                return false;

            // Mark this cell as part of the solution path
            sol[row][col] = 1;

            // STEP 3: Try moving DOWN (row + 1, col)
            if (solveMazeUtil(maze, row + 1, col, sol))
                return true;

            // STEP 4: Try moving RIGHT (row, col + 1)
            if (solveMazeUtil(maze, row, col + 1, sol))
                return true;

            // STEP 5: Backtracking → remove cell from path
            sol[row][col] = 0;
            return false;
        }

        // If not safe, return false
        return false;
    }

    // MAIN METHOD
    public static void main(String args[]) {

        // Maze matrix
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };

        // Call solver
        solveMaze(maze);
    }

}
