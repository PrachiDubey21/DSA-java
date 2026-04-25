import java.util.*;

public class CriticalConnections {

    // Main logic function
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // result list
        List<List<Integer>> result = new ArrayList<>();

        // graph
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        // arrays
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];

        // time wrapped inside array so it can change in DFS
        int[] time = new int[1];

        // DFS for all components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, graph, disc, low, visited, time, result);
            }
        }

        return result;
    }

    // DFS function
    private static void dfs(
            int curr,
            int parent,
            List<Integer>[] graph,
            int[] disc,
            int[] low,
            boolean[] visited,
            int[] time,
            List<List<Integer>> result) {

        visited[curr] = true;
        disc[curr] = low[curr] = ++time[0];

        for (int neigh : graph[curr]) {

            if (neigh == parent)
                continue;

            if (!visited[neigh]) {
                dfs(neigh, curr, graph, disc, low, visited, time, result);

                low[curr] = Math.min(low[curr], low[neigh]);

                // Bridge condition
                if (disc[curr] < low[neigh]) {
                    result.add(Arrays.asList(curr, neigh));
                }

            } else {
                low[curr] = Math.min(low[curr], disc[neigh]);
            }
        }
    }

    // Normal main function
    public static void main(String[] args) {

        int n = 6;
        List<List<Integer>> connections = new ArrayList<>();

        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(0, 3));
        connections.add(Arrays.asList(3, 4));
        connections.add(Arrays.asList(4, 5));
        connections.add(Arrays.asList(5, 3));

        List<List<Integer>> bridges = criticalConnections(n, connections);

        System.out.println("Critical Connections (Bridges):");
        for (List<Integer> bridge : bridges) {
            System.out.println(bridge.get(0) + " - " + bridge.get(1));
        }
    }
}
