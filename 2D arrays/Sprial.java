import java.util.ArrayList;
import java.util.List;

public class Sprial {

    
    public static void spiralOrder(int[][] matrix) {

        int row=matrix.length;
        int column=matrix[0].length;

        int count=0;
        int total=row*column;

        int startingrow=0;
        int startingcol=0;
        int endingrow=row-1;
        int endingcol=column-1;

        while(count<total){

            for(int index=startingcol; count<total&& index<=endingcol;index++){
                System.out.print(matrix[startingrow][index] + " ");
                count++;
            }
            startingrow++;

              for(int index=startingrow ; count<total&& index<=endingrow;index++){
                System.out.print(matrix[index][endingcol] + " ");
                count++;
            }
            endingcol--;

              for(int index=endingcol; count<total&& index>=startingcol;index--){
              System.out.print(matrix[endingrow][index] + " ");
                count++;
            }
            endingrow--;

              for(int index=endingrow; count<total&& index>=startingrow;index--){
                System.out.print(matrix[index][startingcol] + " ");
                count++;
            }
            startingcol++;
        }   
           
    }
        
    

    public static void main(String[] args){

        int matrix[][] = {{1,2,3} , {4,5,6} , {6,7,8}};
        spiralOrder(matrix);
        
    }
    
}
