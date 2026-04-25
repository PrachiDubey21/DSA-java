import java.util.*;

public class KosaRajusAlgo {
    // O(V+ E)

    static class edge {
        int src, dest, wt;

        edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    // Create graph
    public static void createGraph(ArrayList<edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new edge(0, 2, 1));
        graph[0].add(new edge(0, 3, 1));
        graph[1].add(new edge(1, 0, 1));
        graph[2].add(new edge(2, 1, 1));
        graph[3].add(new edge(3, 4, 1));
    }

    // Step 1: Topological sort DFS
    public static void topoDFS(ArrayList<edge>[] graph, int curr,
            boolean[] visited, Stack<Integer> st) {

        visited[curr] = true;

        for (edge e : graph[curr]) {
            if (!visited[e.dest]) {
                topoDFS(graph, e.dest, visited, st);
            }
        }

        st.push(curr);
    }

    // Step 3: DFS on transposed graph
    public static void dfsUtil(ArrayList<edge>[] graph, int curr, boolean[] visited) {

        visited[curr] = true;
        System.out.print(curr + " ");

        for (edge e : graph[curr]) {
            if (!visited[e.dest]) {
                dfsUtil(graph, e.dest, visited);
            }
        }
    }

    public static void kosaraju(ArrayList<edge>[] graph, int V) {

        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];

        // Fill stack
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoDFS(graph, i, visited, st);
            }
        }

        // Step 2 Transpose graph
        ArrayList<edge>[] transpose = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            transpose[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            for (edge e : graph[i]) {
                transpose[e.dest].add(new edge(e.dest, e.src, 1));
            }
        }

        // DFS using stack order
        System.out.println("Strongly Connected Components:");
        while (!st.isEmpty()) {
            int curr = st.pop();

            if (!visited[curr]) {
                dfsUtil(transpose, curr, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;
        ArrayList<edge>[] graph = new ArrayList[V];
        createGraph(graph);

        kosaraju(graph, V);
    }
}
