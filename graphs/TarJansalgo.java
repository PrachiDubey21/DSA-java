import java.util.*;

public class TarJansalgo {
    // O(V + E)

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
        graph[0].add(new edge(0, 1, 1));
        graph[0].add(new edge(0, 2, 1));
        graph[0].add(new edge(0, 3, 1));

        // Vertex 1
        graph[1].add(new edge(1, 0, 1));
        graph[1].add(new edge(1, 2, 1));

        // Vertex 2
        graph[2].add(new edge(2, 0, 1));
        graph[0].add(new edge(2, 1, 1));

        // Vertex 3
        graph[3].add(new edge(3, 0, 1));
        graph[3].add(new edge(3, 4, 1));
        graph[3].add(new edge(3, 5, 1));

        // Vertex 4
        graph[4].add(new edge(4, 3, 1));
        graph[4].add(new edge(4, 5, 1));

        // Vertex 5
        graph[5].add(new edge(5, 3, 1));
        graph[5].add(new edge(5, 4, 1));

    }

    public static void dfs(ArrayList<edge> graph[], int curr, int par,
            int time, int dt[], int low[], boolean vis[]) {

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            int neigh = e.dest;

            // case 1
            if (neigh == par) {
                continue;
            }
            // case 2
            else if (!vis[neigh]) {
                dfs(graph, neigh, curr, time, dt, low, vis);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (dt[curr] < low[neigh]) {
                    System.out.println("Bridge : " + curr + " -> " + neigh);
                }
            }
            // case 3
            else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }

        }

    }

    public static void tarjanBridge(ArrayList<edge> graph[], int V) {

        int disc[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            dfs(graph, i, -1, time, disc, low, vis);
        }
    }

    public static void main(String[] args) {

        int V = 6;
        ArrayList<edge> graph[] = new ArrayList[V];
        createGraph(graph);

        tarjanBridge(graph, V);

    }

}
