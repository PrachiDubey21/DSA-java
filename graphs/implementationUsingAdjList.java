import java.util.*;

public class implementationUsingAdjList {

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

    public static void main(String[] args) {

        int vertex = 5;

        ArrayList<edge>[] graph = new ArrayList[vertex];

        for (int i = 0; i < vertex; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new edge(0, 1, 5));

        graph[1].add(new edge(1, 0, 5));
        graph[1].add(new edge(1, 2, 1));
        graph[1].add(new edge(1, 3, 3));

        graph[2].add(new edge(2, 1, 1));
        graph[2].add(new edge(2, 3, 1));
        graph[2].add(new edge(2, 4, 2));

        graph[3].add(new edge(3, 1, 3));
        graph[3].add(new edge(3, 2, 1));

        graph[4].add(new edge(4, 2, 2));

       
        //for storing neighbours
        int n = 2;

        for(int i=0;i<graph[n].size();i++){

            edge e = graph[n].get(i);
            System.out.println(e.src + "->" + e.dest + " : " + e.wt);

        }

    }

}
