import java.util.*;

public class topologicalSort {

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

        graph[5].add(new edge(5, 2, 1));
        graph[5].add(new edge(5, 0, 1));

        graph[4].add(new edge(4, 0, 1));
        graph[4].add(new edge(4, 1, 1));

        graph[2].add(new edge(2, 3, 1));
        graph[3].add(new edge(3, 1, 1));

    }

    public static void toposort(ArrayList<edge>[] graph) {

        boolean[] visited = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        // visit neighbours
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                toposortutil(graph, i, visited, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }

    public static void toposortutil(ArrayList<edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {

        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                toposortutil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
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
