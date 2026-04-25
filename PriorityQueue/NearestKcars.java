import java.util.*;

public class NearestKcars {

    static class point implements Comparable<point>{
        int x;
        int y;
        int dist;
        int i;

       public point(int x , int y , int d , int i){
        this.x = x;
        this.y = y;
        this.dist = d;
        this.i = i;

       }

       @Override
       public int compareTo(point p2){
        return this.dist - p2.dist;
       }

    }

    public static void main(String[] args){

        int pt[][] = {{3,3} , {5,-1} , {-2,4}};
        int k=2;

        PriorityQueue<point> pq = new PriorityQueue<>();

        for(int i=0;i<pt.length;i++){
            int distsq = (pt[i][0]*pt[i][0]) + (pt[i][1] * pt[i][1] );
            pq.add(new point(pt[i][0] , pt[i][1] , distsq  , i));
        }

        for(int i=0;i<k;i++){
            System.out.println(pq.poll().i); 
        }
    }
    
}
