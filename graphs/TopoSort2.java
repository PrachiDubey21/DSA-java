import java.util.*;

class TopoSort2 {

    static void topoDFS(int node, ArrayList<ArrayList<Integer>> graph,
                        boolean[] visited, Stack<Integer> st) {

        visited[node] = true;

        for (int neigh : graph.get(node)) {
            if (!visited[neigh]) {
                topoDFS(neigh, graph, visited, st);
            }
        }

        // push after visiting all neighbours
        st.push(node);
    }

    static void topologicalSort(int V, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoDFS(i, graph, visited, st);
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        topologicalSort(V, graph);
    }
}
