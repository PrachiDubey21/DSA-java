import java.util.*;

public class FinishAllTask {

    static boolean dfs(int node, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adj) {

        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, recStack, adj)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true; // cycle detected
            }
        }

        recStack[node] = false;
        return false;
    }

    static boolean canFinish(int V, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]); // b → a
        }

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recStack, adj)) {
                    return false; // cycle exists
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] prereq1 = { { 1, 0 }, { 0, 1 } };
        System.out.println(canFinish(2, prereq1)); // false

        int[][] prereq2 = { { 1, 0 } };
        System.out.println(canFinish(2, prereq2)); // true
    }

}
