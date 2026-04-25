import java.util.*;

public class cycledetection {

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
        graph[0].add(new edge(0, 3, 1));

        // Vertex 1
        graph[1].add(new edge(1, 0, 1));
        graph[1].add(new edge(1, 2, 1));

        // Vertex 2
        graph[2].add(new edge(2, 0, 1));
        graph[2].add(new edge(2, 1, 1));

        // Vertex 3
        graph[3].add(new edge(3, 0, 1));
        graph[3].add(new edge(3, 4, 1));

        // Vertex 4
        graph[4].add(new edge(4, 3, 1));

    }

    public static boolean detectcycle(ArrayList<edge>[] graph) {

        boolean visit[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                if (detectcycleutil(graph, visit, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectcycleutil(ArrayList<edge>[] graph, boolean[] visited, int curr, int par) {

        visited[curr] = true;

        // visit neighbours
        for (int i = 0; i < graph[curr].size(); i++) {

            edge e = graph[curr].get(i);

            // case 3
            if (!visited[e.dest]) {
                if(detectcycleutil(graph, visited, e.dest, curr)){
                return true;
                }
            }

            // case 2
            else if (visited[e.dest] && e.dest != par) {
                return true;
            }
            // else case 2 continue

        }

        return false;

    }

    public static void main(String[] args) {

        int vertex = 7;

        ArrayList<edge>[] graph = new ArrayList[vertex];
        createGraph(graph);

        System.out.println(detectcycle(graph));

    }
}
