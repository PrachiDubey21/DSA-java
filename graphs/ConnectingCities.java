import java.util.*;

public class ConnectingCities {

    static class edge implements Comparable<edge> {

        int dest;
        int cost;

        public edge(int d, int c) {

            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(edge e2) {
            return this.cost - e2.cost;
        }
    }

    public static int minimumcost(int cities[][]) {

        boolean vis[] = new boolean[cities.length];
        PriorityQueue<edge> pq = new PriorityQueue<>();
        int finalCost = 0;

        pq.add(new edge(0, 0));

        while (!pq.isEmpty()) {
            edge curr = pq.remove();

            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost = finalCost + curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {

                    if (cities[curr.dest][i] != 0) {
                        pq.add(new edge(i, cities[curr.dest][i]));
                    }

                }
            }
        }

       return finalCost;
    }

    public static void main(String[] args) {

        int vertex = 4;
        int cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0, },
                { 4, 7, 0, 0, 0 } };


        System.out.println(minimumcost( cities));

    }
}
