public class Selection {

    //o(n2)

    public static void SelectionSort(int arr[]){

        int n=arr.length;
        for(int i=0;i<n-1;i++){


            //assume i is the minimum element
            int smallest=i;

            for(int j=i+1;j<n;j++){

                //if there is smaller element than arr[i]
                //then change the index to the smallest element
                if(arr[j]<arr[smallest]){
                   smallest=j;
                }
            }

            //now we have the smallest element index
            //swap it with the front index
            int temp=arr[smallest];
            arr[smallest]=arr[i];
            arr[i]=temp;
            
        }

    }

    public static void main(String[] args){
        
        int arr[] = { 5, 4, 3, 2, 1 ,12,34,3,4,5,7,9};
        System.out.println();

        System.out.println("Before sorting : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        SelectionSort(arr);

        System.out.println();
        System.out.println();
        System.out.println("after sorting : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    
    }
    
}
