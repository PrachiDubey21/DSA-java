import java.util.*;

public class SourceToPath {

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

        graph[5].add(new edge(5, 2, 1));
        graph[5].add(new edge(5, 0, 1));

        graph[0].add(new edge(0, 3, 1));

        graph[4].add(new edge(4, 0, 1));
        graph[4].add(new edge(4, 1, 1));

        graph[2].add(new edge(2, 3, 1));
        graph[3].add(new edge(3, 1, 1));

    }

   
    public static void Path(ArrayList<edge>[] graph , int src , int dest , String path) {

      if(src==dest){
        System.out.println(path+dest);
        return;
      }

      for(int i=0;i<graph[src].size();i++){

        edge e = graph[src].get(i);
        Path(graph, e.dest, dest, path+src);

      }

    }

    public static void main(String[] args) {

        int vertex = 6;

        ArrayList<edge>[] graph = new ArrayList[vertex];
        createGraph(graph);

        boolean[] visited = new boolean[vertex];

        Path(graph, 5, 1, "");

    }
}
