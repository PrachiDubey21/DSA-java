import java.util.*;

public class StronglyConnectedComponents {

    static class edge {
        int src;
        int dest;
        int wt;

        public edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Create graph
    public static void createGraph(ArrayList<edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Vertex 0
        graph[0].add(new edge(0, 2, 1));
        graph[0].add(new edge(0, 3, 1));

        // Vertex 1
        graph[1].add(new edge(1, 0, 1));

        // Vertex 2
        graph[2].add(new edge(2, 1, 1));

        // Vertex 3
        graph[3].add(new edge(3, 4, 1));

    }

    // Helper DFS function
    public static void dfsUtil(ArrayList<edge>[] graph, int curr, boolean[] visited) {

        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);

            if (!visited[e.dest]) {
                dfsUtil(graph, e.dest, visited);
            }
        }
    }

    public static void dfs(ArrayList<edge>[] graph, int vertex) {

        boolean[] visited = new boolean[vertex];

        for (int i = vertex - 1 ; i >= 0; i--) {
            if (!visited[i]) {
                dfsUtil(graph, i, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        int vertex = 5;

        ArrayList<edge>[] graph = new ArrayList[vertex];
        createGraph(graph);

        System.out.println("DFS Traversal (Disconnected Graph):");
        dfs(graph, vertex);
    }

}
