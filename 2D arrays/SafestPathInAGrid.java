import java.util.*;

public class SafestPathInAGrid {

    // The safeness of a cell is Distance to the nearest thief
    // 2 1 0
    // 1 2 1
    // 0 1 2

    // Here 2 means nearest thief is 2 cells away.
    // 0 means thief is standing there.

    // Find a path where the minimum safeness on the path is as large as possible
    // Path 1 -> 4 → 4 → 3 → 2 → 1 so Minimum is 1

    // Suppose thieves are here.
    // Using BFS
    // 0 0 1 2 1 0
    // 0 0 0 -> 1 2 1
    // 1 0 0 0 1 2

    // then use Priority Queue , Always go to the safest cell first.
    // Suppose current path -> 4
    // Next cell ->2
    // Current path safety becomes -> min(4,2)=2

    // newSafety = Math.min(currentSafety, nextCellSafety);

    // instead of a normal queue (like BFS), we use a max-heap priority queue that
    // always picks the path with the highest current safety first.

    public static int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        // dist[i][j] = Distance of cell (i,j) from the nearest thief
        int[][] dist = new int[n][n];

        // Initially mark every cell as not visited (-1)
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        // Queue for Multi-Source BFS
        Queue<int[]> q = new LinkedList<>();

        // ----------------------------------------------------------
        // STEP 1: Put every thief into the queue

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // If current cell has a thief
                if (grid.get(i).get(j) == 1) {

                    // Distance from thief to itself is 0
                    dist[i][j] = 0;

                    // Add thief position into queue
                    q.offer(new int[] { i, j });
                }
            }
        }

        //-------------------------------------------------------------

        // Four directions
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        // ----------------------------------------------------
        // STEP 2: Multi Source BFS
        // Calculates distance of every cell from nearest thief

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            // Visit all four neighbours
            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                // Ignore cells outside the grid
                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                // Already visited
                if (dist[nr][nc] != -1)
                    continue;

                // Neighbour distance = Current distance + 1
                dist[nr][nc] = dist[r][c] + 1;

                // Push neighbour into queue
                q.offer(new int[] { nr, nc });
            }
        }

        //----------------------------------------------------------------------

        /*
         * Example dist[][]
         * 
         * 2 1 0
         * 1 2 1
         * 0 1 2
         * 
         * Larger value = Safer cell
         */

        // ---------------------------------------------------------
        // STEP 3: Max Heap (Priority Queue)
        // Always process the safest path first


        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]);

        // Visited array for Dijkstra
        boolean[][] visited = new boolean[n][n];

        // Start from (0,0)

        // {current path safety, row, column}
        pq.offer(new int[] { dist[0][0], 0, 0 });

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int safe = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (visited[r][c])
                continue;

            visited[r][c] = true;

            // Destination reached
            if (r == n - 1 && c == n - 1)
                return safe;

            // Explore all four neighbours
            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                if (visited[nr][nc])
                    continue;

                /*
                 * Current path safety = safe
                 * 
                 * Next cell safety = dist[nr][nc]
                 * 
                 * Overall path safety =
                 * minimum of these two
                 * 
                 * Because the weakest point
                 * decides the safety of the path.
                 */

                int newSafe = Math.min(safe, dist[nr][nc]);

                pq.offer(new int[] { newSafe, nr, nc });
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        List<List<Integer>> grid = new ArrayList<>();

        grid.add(Arrays.asList(0, 0, 1));
        grid.add(Arrays.asList(0, 0, 0));
        grid.add(Arrays.asList(1, 0, 0));

        int answer = maximumSafenessFactor(grid);
        System.out.println(answer);

    }

}
