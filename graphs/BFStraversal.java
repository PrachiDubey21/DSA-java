import java.util.*;

public class BFStraversal {

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
        graph[0].add(new edge(0, 1, 1));
        graph[0].add(new edge(0, 2, 1));

        // Vertex 1
        graph[1].add(new edge(1, 0, 1));
        graph[1].add(new edge(1, 3, 1));

        // Vertex 2
        graph[2].add(new edge(2, 0, 1));
        graph[2].add(new edge(2, 4, 1));

        // Vertex 3
        graph[3].add(new edge(3, 1, 1));
        graph[3].add(new edge(3, 4, 1));
        graph[3].add(new edge(3, 5, 1));

        // Vertex 4
        graph[4].add(new edge(4, 2, 1));
        graph[4].add(new edge(4, 3, 1));
        graph[4].add(new edge(4, 5, 1));

        // Vertex 5
        graph[5].add(new edge(5, 3, 1));
        graph[5].add(new edge(5, 4, 1));
        graph[5].add(new edge(5, 6, 1));

        // Vertex 6
        graph[6].add(new edge(6, 5, 1));
    }

    public static void printNeighbours(ArrayList<edge>[] graph, int v) {

        System.out.println("Neighbours of vertex " + v + " :");

        for (int i = 0; i < graph[v].size(); i++) {
            edge e = graph[v].get(i);
            System.out.println(e.src + " -> " + e.dest + " : " + e.wt);
        }
    }

    public static void bfs(ArrayList<edge>[] graph, int start) {

        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        while (!q.isEmpty()) {

            int curr = q.remove(); // remove current

            if (!visited[curr]) { // if not visited

                System.out.print(curr + " ");
                visited[curr] = true;

                // add neighbours
                for (int i = 0; i < graph[curr].size(); i++) {
                    edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {

        int vertex = 7;

        ArrayList<edge>[] graph = new ArrayList[vertex];
        createGraph(graph);

        bfs(graph, 0);

    }
}
