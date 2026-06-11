import java.util.*;

public class AssignEdgeWeight {

    static int maxDepth = 0;

    public static int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1, -1, 0, graph);

        long ans = 1;
        int MOD = 1000000007;

        for (int i = 1; i < maxDepth; i++) {
            ans = (ans * 2) % MOD;
        }

        return (int) ans;
    }

    public static void dfs(int curr, int parent, int depth, ArrayList<Integer>[] graph) {

        if (depth > maxDepth) {
            maxDepth = depth;
        }

        for (int next : graph[curr]) {

            if (next != parent) {
                dfs(next, curr, depth + 1, graph);
            }
        }
    }

    public static void main(String[] args) {

        int[][] edges = {
                { 1, 2 },
                { 1, 3 },
                { 3, 4 },
                { 3, 5 }
        };

        int ans = assignEdgeWeights(edges);

        System.out.println("Answer: " + ans);
        
    }
}
