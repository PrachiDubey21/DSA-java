import java.util.*;

public class KrusKalsAlgo {
    // O(V + elog e)

    static class edge implements Comparable<edge> {

        int src;
        int dest;
        int wt;

        public edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(edge e2) {
            return this.wt - e2.wt;
        }
    }

    static void creategraph(ArrayList<edge> edges) {

        edges.add(new edge(0, 1, 10));
        edges.add(new edge(0, 2, 15));
        edges.add(new edge(0, 3, 30));
        edges.add(new edge(1, 3, 40));
        edges.add(new edge(2, 3, 50));
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {

        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x) {

        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {

        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {

            par[parB] = parA;
            rank[parA]++;

        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }

    }

    public static void KrusKalsMST(ArrayList<edge> e, int V) {

        Collections.sort(e);
        int cost = 0;
        int count = 0;

        for (int i = 0; count < V - 1; i++) {
            edge edges = e.get(i);

            int a = edges.src;
            int b = edges.dest;

            int parA = find(a);
            int parB = find(b);

            if (parA != parB) {
                union(a, b);
                cost = cost + edges.wt;
                count++;
            }
        }

        System.out.println(cost);
    }

    public static void main(String[] args) {

        int V = 4;
        ArrayList<edge> e = new ArrayList<>();
        creategraph(e);
        init();

        KrusKalsMST(e, V);

    }
}
