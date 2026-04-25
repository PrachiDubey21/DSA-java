import java.util.*;

public class PQforObjects {

    static class student implements Comparable<student>{
        String name;
        int rank;

        public student(String s , int r){
            this.name = s;
            this.rank = r;
        }

        @Override
        //either returns -ve , 0 or +ve
        public int compareTo(student s2){
            return this.rank - s2.rank;
        }

    }

    public static void main(String[] arg){

          PriorityQueue<student> pq = new PriorityQueue<>();
        //by default the smallest element will given more priority 

        // Insert elements
        pq.add(new student("prachi", 5));
        pq.add(new student("aditi", 2));
         pq.add(new student("radhika", 12));
          pq.add(new student("misha", 20 ));

        System.out.println();

        // Removing elements
        while (!pq.isEmpty()) {
            System.out.println("Peek: " + pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }
        System.out.println();
    


    }

}
