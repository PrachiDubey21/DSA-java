import java.util.*;

public class BiPartile {

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
        graph[0].add(new edge(0, 1, 1));
        graph[0].add(new edge(0, 2, 1));

        // Vertex 1
        graph[1].add(new edge(1, 0, 1));
        graph[1].add(new edge(1, 3, 1));

        // Vertex 2
        graph[2].add(new edge(2, 0, 1));
        graph[2].add(new edge(2, 4, 1));

        // Vertex 3
        graph[3].add(new edge(3, 1, 1));
        graph[3].add(new edge(3, 4, 1));

        // Vertex 4
        graph[4].add(new edge(4, 2, 1));
        graph[4].add(new edge(4, 3, 1));

    }

    public static boolean isbipartile(ArrayList<edge>[] graph) {

        int colour[] = new int[graph.length];

        for (int i = 0; i < colour.length; i++) {
            colour[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {

            if (colour[i] == -1) {
                q.add(i);
                colour[i] = 0;

                while (!q.isEmpty()) {

                    int curr = q.remove(); // remove current

                    // add neighbours
                    for (int j = 0; j < graph[curr].size(); j++) {
                        edge e = graph[curr].get(j);

                        // case 1
                        if (colour[e.dest] == -1) {
                            int nextcol;
                            if (colour[curr] == 0) {
                                nextcol = 1;
                            } else {
                                nextcol = 0;
                            }
                            colour[e.dest] = nextcol;
                            q.add(e.dest);
                        }

                        // case 2
                        else if (colour[e.dest] == colour[curr]) {
                            return false;
                        }
                    }

                }

            }
        }

        return true;
    }

    public static void main(String[] args) {

        int vertex = 7;

        ArrayList<edge>[] graph = new ArrayList[vertex];
        createGraph(graph);

       System.out.println( isbipartile(graph));

    }
}
