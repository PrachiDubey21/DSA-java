public class FillElemenetInArray {

    public static void fill(int arr[] , int index , int value ){

        //basecase
        if(index==arr.length){
            print(arr);
            return;
        }

        //recursion
        arr[index] = value;
        fill(arr,index + 1,value +1 );

        //backtrack
        arr[index] = arr[index] - 2;

    }

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        int arr[] = new int[5];
        
        //first we need 1,2,3,4,5
        //then we need -1,0,1,2,3 (-2)

        fill(arr,0,1);
        print(arr);



    }
}
