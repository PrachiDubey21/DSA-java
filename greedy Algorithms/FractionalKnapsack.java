import java.util.*;

public class FractionalKnapsack {

    public static int Cal(int val[] , int wt[] , int W){

        
        double ratio[][] = new double[val.length][2];

        for(int i=0;i<val.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = (double) (val[i] / wt[i]);
        }

        Arrays.sort(ratio , Comparator.comparingDouble(o -> o[1]));

        int capacity=W;
        int finalvalue =0;

        //since array is sorted in ascending order
        for(int i=ratio.length-1 ; i>=0;i--){

            int index = (int)ratio[i][0];

            if(capacity>=wt[index]){
                finalvalue = finalvalue + val[index];
                capacity = capacity - wt[index];
            }
            else{
                finalvalue = finalvalue + (int)(ratio[i][1] * capacity);
                break;
            }

        }
        return finalvalue;
    }

    public static void main(String[] args){

        int values[] = {60,100,120};
        int weights[] = {10,20,30};
        int W =50;


        int ans = Cal(values , weights , W);
        System.out.println("the finalvalue is : " + ans);



    }


    
}
