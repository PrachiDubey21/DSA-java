import java.util.*;

public class PrimsAlgo {

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

        // Vertex 0
        graph[0].add(new edge(0, 1, 10));
        graph[0].add(new edge(0, 2, 15));
        graph[0].add(new edge(0, 3, 30));

        // Vertex 1
        graph[1].add(new edge(1, 0, 10));
        graph[1].add(new edge(1, 3, 40));

        // Vertex 2
        graph[2].add(new edge(2, 0, 15));
        graph[2].add(new edge(2, 3, 50));

        // Vertex 3
        graph[3].add(new edge(3, 1, 40));
        graph[3].add(new edge(3, 2, 50));

    }

    public static class pair implements Comparable<pair>{

        int vertex;
        int cost;

        public pair(int v , int c){
            this.vertex = v;
            this.cost = c;
        }

        @Override
        public int compareTo(pair p2){
            return this.cost- p2.cost;
        }
    }

    public static void Prims(ArrayList<edge>[] graph, int start) {

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int Cost = 0;

        pq.add(new pair(start, 0));

        while(!pq.isEmpty()){
            pair curr = pq.remove();

            if(!vis[curr.vertex]){
                vis[curr.vertex] = true;
                Cost = Cost + curr.cost;

                for(int i=0;i<graph[curr.vertex].size();i++){
                    edge e = graph[curr.vertex].get(i);

                    pq.add(new pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("total cost of MST is : " + Cost);
    }

    public static void main(String[] args) {

        int vertex = 4;

        ArrayList<edge>[] graph = new ArrayList[vertex];
        createGraph(graph);

       Prims(graph, 0);

    }
}
