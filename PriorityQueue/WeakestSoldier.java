import java.util.*;

public class WeakestSoldier {

    static class row implements Comparable<row>{
        int soldier;
        int i;

        public row(int s , int i){
            this.soldier = s;
            this.i = i;
        }

        @Override
        public int compareTo(row r2){
           
            if(this.soldier == r2.soldier){
                return this.i - r2.i;
            }
            else{
                return this.soldier - r2.soldier;
            }
        }
    }

     public static void main(String[] args){

        int army[][] = {{1,0,0,0} ,
                        {1,1,1,1} , 
                        {1,0,0,0} , 
                        {1,0,0,0}};
        int k=2;

        PriorityQueue<row> pq = new PriorityQueue<>();

        for(int i=0;i<army.length;i++){
            int count=0;
            for(int j=0;j<army[0].length;j++){
                if(army[i][j] == 1 ){
                    count++;
                }
            }
            pq.add(new row(count , i));
        }

        for(int i=0;i<k;i++){
            System.out.println(pq.remove().i);
        }
     }
    
}
