import java.util.*;

public class MajorityElement {

    public static void main(String[] args){

        int arr[] = {1,3,2,5,1,3,1,5,1};
        int n = arr.length;
        int m = (n/3);

        HashMap<Integer , Integer> hm = new HashMap<>();

        for(int i=0;i<n;i++){

             int num = arr[i];

            // if(hm.containsKey(num)){
            //     hm.put(num,hm.get(num)+1);
            // }
            // else{
            //     hm.put(num,1);
            // }

            hm.put(num , hm.getOrDefault(num,0 ) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();

       for (Integer key : hm.keySet()) {
        if(hm.get(key) > m){
            list.add(key);
        }
       }

       System.out.println(list);

    }
    
}
