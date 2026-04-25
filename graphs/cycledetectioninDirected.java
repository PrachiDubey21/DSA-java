import java.util.*;

public class cycledetectioninDirected {

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

        // Vertex 1
        graph[1].add(new edge(1, 0, 1));

        // Vertex 2
        graph[2].add(new edge(2, 3, 1));

        // Vertex 3
        graph[3].add(new edge(3, 0, 1));

    }

    // Helper DFS function
    public static boolean iscycleutil(ArrayList<edge>[] graph, int curr,  boolean[] vis ,  boolean[] s) {

        vis[curr] = true;
        s[curr] = true; 

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);

            if (s[e.dest]) {
                return true;
            }
            else if (!vis[e.dest] ){
                if(iscycleutil(graph, e.dest, vis, s)){
                    return true;
                }
            }
        }

        s[curr] = false;
        return false;
    }

    public static boolean iscycle(ArrayList<edge>[] graph) {

        boolean[] visited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
               if(iscycleutil(graph , i , visited , stack)){
                return true;
               }
            }
        }
        return false;
    }


    public static void main(String[] args) {

        int vertex = 4;

        ArrayList<edge>[] graph = new ArrayList[vertex];
        createGraph(graph);

        System.out.println( iscycle(graph));
       
    }
}
