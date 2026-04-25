import java.util.*;

import java.util.Comparator;

public class MaxLengthChainOfPairs {

    public static int maxlength(int pairs[][]){

        Arrays.sort(pairs,Comparator.comparingDouble(o -> o[1]));

        int chain = 1;
        int lastend = pairs[0][1];

        for(int i=1 ; i<pairs.length;i++){
            if(pairs[i][0] > lastend){
                chain++;
                lastend = pairs[i][1];
            }
        }
        return chain;

    }
    
    public static void main(String[] args){

        int pairs[][] = {{5,24} , {39,60} , {5,28} , {27,40} , {50,90}};

        int ans  = maxlength(pairs);
        System.out.println("the length of chain is : " + ans);

    }
}
