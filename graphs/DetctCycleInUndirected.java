import java.util.*;

public class DetctCycleInUndirected {

    static class Pair {
        int node, parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                if (bfs(i, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(start, -1));
        visited[start] = true;

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();
            int node = curr.node;
            int parent = curr.parent;

            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new Pair(neighbor, node));
                }
                else if (neighbor != parent) {
                    return true; // cycle found
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 3;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph:
        // 0 - 1
        // |   |
        // 2 --

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(0);
        adj.get(0).add(2);

        System.out.println(isCycle(V, adj)); // true
    }
    
}
