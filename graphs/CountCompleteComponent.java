import java.util.*;

public class CountCompleteComponent {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static int[] dfs(int node) {

        visited[node] = true;

        int vertices = 1;                    // count current node
        int degree = graph[node].size();     // degree of current node

        for (int neighbor : graph[node]) {

            if (!visited[neighbor]) {

                int[] result = dfs(neighbor);

                vertices += result[0];
                degree += result[1];
            }
        }

        return new int[]{vertices, degree};
    }

    static int countCompleteComponents(int n, int[][] edges) {

        // adjacency list
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // building graph
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        visited = new boolean[n];
        int answer = 0;

        // traversing component
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                int[] info = dfs(i);

                int vertices = info[0];
                int degree = info[1];

                int actedges = degree / 2;
                int expedges = vertices * (vertices - 1) / 2;

                if (actedges == expedges) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int n = 6;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4}
        };

        int result = countCompleteComponents(n, edges);
        System.out.println("Number of Complete Components = " + result);

    }
}