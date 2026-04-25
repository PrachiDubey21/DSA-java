import java.util.*;

public class bellmanAlgo2 {
    // O(V*e)

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

    public static void createGraph(ArrayList<edge> graph) {

        for (int i = 0; i < graph.size(); i++) {
            graph = new ArrayList<>();
        }

        // Vertex 0
        graph.add(new edge(0, 1, 2));
        graph.add(new edge(0, 2, 4));

        // Vertex 1
        graph.add(new edge(1, 2, -4));

        // Vertex 2
        graph.add(new edge(2, 3, 2));

        // Vertex 3
        graph.add(new edge(3, 4, 4));

        // Vertex 4
        graph.add(new edge(4, 1, -1));

    }


    public static void ShortestPath(ArrayList<edge> graph, int src , int V) {

        int dist[] = new int[V];

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // O(V)
        for (int i = 0; i < V - 1; i++) {

            // edge = O(e)

            for (int j = 0; j < graph.size(); j++)  {
                    edge e = graph.get(j);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    //as if we add anything in infinity will make the
                    //number negative 
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }

            }
        
        // print
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {

        int vertex = 5;

        ArrayList<edge> graph = new ArrayList<>();
        createGraph(graph);

        ShortestPath(graph, 0 , vertex);

    }
}
