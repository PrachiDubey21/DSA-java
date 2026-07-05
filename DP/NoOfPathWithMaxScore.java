import java.util.*;

public class NoOfPathWithMaxScore {

// E 2 3
// 2 X 2
// 1 2 S

// find ->
// Maximum score you can collect
// How many paths give that maximum score

// For every cell ->

// Look at:
// Up
// Left
// Diagonal

// Find the maximum score among them and if one neighbor has the maximum
// take its ways if two neighbors tie add their ways
// Then current score = maximum neighbor score + current cell value

// For every cell (i, j)

// ways = sum of all neighbors whose score == max

// score[i][j] =
// max(
//     score[i+1][j],      // Down
//     score[i][j+1],      // Right
//     score[i+1][j+1]     // Diagonal
// )
// + currentCellValue
// (If the cell is E or S, add 0 instead of a value)

    public static int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();
        int MOD = 1000000007;

        // Maximum score to reach S
        int[][] dpS = new int[n][n];

        // Number of ways to get that maximum score
        int[][] dpW = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dpS[i], -1);
        }

        // Start from S
        dpS[n - 1][n - 1] = 0;
        dpW[n - 1][n - 1] = 1;

        // Traverse from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                char ch = board.get(i).charAt(j);

                // Skip blocked cells and S
                if (ch == 'X' || (i == n - 1 && j == n - 1))
                    continue;

                int best = -1;
                int ways = 0;

                // Down
                if (i + 1 < n && dpS[i + 1][j] != -1) {

                    if (dpS[i + 1][j] > best) {
                        best = dpS[i + 1][j];
                        ways = dpW[i + 1][j];
                    } 
                    else if (dpS[i + 1][j] == best) {
                        ways = (ways + dpW[i + 1][j]) % MOD;
                    }

                }

                // Right
                if (j + 1 < n && dpS[i][j + 1] != -1) {

                    if (dpS[i][j + 1] > best) {
                        best = dpS[i][j + 1];
                        ways = dpW[i][j + 1];
                    }
                     else if (dpS[i][j + 1] == best) {
                        ways = (ways + dpW[i][j + 1]) % MOD;
                    }

                }

                // Diagonal
                if (i + 1 < n && j + 1 < n && dpS[i + 1][j + 1] != -1) {

                    if (dpS[i + 1][j + 1] > best) {
                        best = dpS[i + 1][j + 1];
                        ways = dpW[i + 1][j + 1];
                    }
                     else if (dpS[i + 1][j + 1] == best) {
                        ways = (ways + dpW[i + 1][j + 1]) % MOD;
                    }

                }

                // No path from this cell
                if (best == -1)
                    continue;

                dpW[i][j] = ways;

                // Don't add value for E
                if (ch == 'E') {
                    dpS[i][j] = best;
                } 
                else {
                    dpS[i][j] = best + (ch - '0');
                }
            }
        }

        if (dpW[0][0] == 0) {
            return new int[]{0, 0};
        }

        return new int[]{dpS[0][0], dpW[0][0]};
    }



    public static void main(String[] args) {

        List<String> board = new ArrayList<>();

        // Hardcoded Example
        board.add("E23");
        board.add("2X2");
        board.add("12S");

        int[] ans = pathsWithMaxScore(board);

        System.out.println("Maximum Score = " + ans[0]);
        System.out.println("Number of Paths = " + ans[1]);
    }
    
}
