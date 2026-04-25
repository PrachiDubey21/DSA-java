import java.util.*;

public class FloydWarshallAlgo {

    public static void floydWarshall(int[][] dist) {

        int V = dist.length;

        for (int k = 0; k < V; k++) {

            for (int i = 0; i < V; i++) {

                for (int j = 0; j < V; j++) {

                    if (dist[i][k] != Integer.MAX_VALUE &&
                        dist[k][j] != Integer.MAX_VALUE) {

                        dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int INF = Integer.MAX_VALUE;

        int[][] graph = {
            {0,   5,  INF, 10},
            {INF, 0,   3, INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
        };

        floydWarshall(graph);

        // print result
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(graph[i][j] + "   ");
            }
            System.out.println();
        }
    }
    
}
