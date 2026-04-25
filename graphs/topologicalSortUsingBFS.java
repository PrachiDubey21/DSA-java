import java.util.*;

public class topologicalSortUsingBFS {

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

        graph[4].add(new edge(5, 2, 1));
        graph[5].add(new edge(5, 0, 1));

        graph[4].add(new edge(4, 0, 1));
        graph[4].add(new edge(4, 1, 1));

        graph[2].add(new edge(2, 3, 1));
        graph[3].add(new edge(3, 1, 1));

    }

    public static void calc(ArrayList<edge>[] graph, int degree[]) {

        for (int i = 0; i < graph.length; i++) {

            int v = i;

            for (int j = 0; j < graph[v].size(); j++) {
                edge e = graph[v].get(j);

                degree[e.dest]++;
            }
        }
    }

    public static void toposort(ArrayList<edge>[] graph) {

        int degree[] = new int[graph.length];
        calc(graph, degree);

        Queue<Integer> q = new LinkedList<>();
 
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();

            System.out.print(curr + " ");

            for (int j = 0; j < graph[curr].size(); j++) {
                edge e = graph[curr].get(j);

                degree[e.dest]--;

                if (degree[e.dest] == 0) {
                    q.add(e.dest);
                }

            }

        }

        System.out.println();

    }

    public static void main(String[] args) {

        int vertex = 6;

        ArrayList<edge>[] graph = new ArrayList[vertex];
        createGraph(graph);

        boolean[] visited = new boolean[vertex];

        System.out.print(" topological sort: ");
        toposort(graph);

    }
}
