import java.util.*;

public class UnionFind {


    static int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent); // path compression
        }
        return parent[x];
    }

    static boolean union(int x, int y, int[] parent) {
        int px = find(x, parent);
        int py = find(y, parent);

        if (px == py) {
            return true; // cycle detected
        }

        parent[px] = py; // union
        return false;
    }

    public static void main(String[] args) {

        int[] parent = new int[10];

        // initialize
        for (int i = 0; i < 10; i++) {
            parent[i] = i;
        }

        int[][] edges = {
            {9, 5},
            {5, 2},
            {2, 7},
            {9, 1},
            {5, 1}
        };

        boolean hasCycle = false;
       
        for (int[] edge : edges) {
            if (union(edge[0], edge[1], parent)) {
                hasCycle = true;
                break; // stop early
            }
        }

        if (hasCycle) {
            System.out.println("Yes, cycle exists");
        } else {
            System.out.println("No cycle");
        }
    }
    
}
