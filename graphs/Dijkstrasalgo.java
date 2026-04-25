import java.util.*;

public class Dijkstrasalgo {
    // O(v + elog v)

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

    public static void createGraph(ArrayList<edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Vertex 0
        graph[0].add(new edge(0, 1, 2));
        graph[0].add(new edge(0, 2, 4));

        // Vertex 1
        graph[1].add(new edge(1, 3, 7));
        graph[1].add(new edge(1, 2, 1));

        // Vertex 2
        graph[2].add(new edge(2, 4, 3));

        // Vertex 3
        graph[3].add(new edge(3, 5, 1));

        // Vertex 4
        graph[4].add(new edge(4, 3, 2));
        graph[4].add(new edge(4, 5, 5));

    }

    static class Pair implements Comparable<Pair> {

        int node;
        int path;

        public Pair(int n, int p) {
            this.node = n;
            this.path = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void ShortestPath(ArrayList<edge>[] graph, int src) {

        int dist[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (!vis[curr.node]) {

                vis[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    edge e = graph[curr.node].get(i);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }

                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        // print
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {

        int vertex = 6;

        ArrayList<edge>[] graph = new ArrayList[vertex];
        createGraph(graph);

        ShortestPath(graph, 0);

    }
}
