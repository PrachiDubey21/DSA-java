import java.util.*;

public class MotherVertex {

    static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }

    static int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        int candidate = -1;

        // Find candidate
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj);
                candidate = i;
            }
        }

        // Verify candidate
        Arrays.fill(visited, false);
        dfs(candidate, visited, adj);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return -1; // no mother vertex
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Given graph
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(2).add(1);
        adj.get(3).add(4);

        int mother = findMotherVertex(V, adj);

        if (mother == -1)
            System.out.println("No Mother Vertex");
        else
            System.out.println("Mother Vertex is: " + mother);
    }
    
}
