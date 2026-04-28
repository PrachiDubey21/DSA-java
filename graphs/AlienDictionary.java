import java.util.*;

public class AlienDictionary {

    public static String findOrder(String[] dict, int N, int K) {

        // create graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[K];

        // build graph from dictionary
        for (int i = 0; i < N - 1; i++) {
            String w1 = dict[i];
            String w2 = dict[i + 1];

            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    int u = w1.charAt(j) - 'a';
                    int v = w2.charAt(j) - 'a';

                    adj.get(u).add(v);
                    indegree[v]++;
                    break; // only first mismatch matters
                }
            }
        }

        // topological Sort (BFS)
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!q.isEmpty()) {
            int node = q.poll();
            result.append((char)(node + 'a'));

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // check if valid
        if (result.length() < K) {
            return ""; // cycle or invalid
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String[] dict1 = {"caa","aaa","aab"};
        System.out.println(findOrder(dict1, 3, 3));

        String[] dict2 = {"baa","abcd","abca","cab","cad"};
        System.out.println(findOrder(dict2, 5, 4));
    }
    
}
