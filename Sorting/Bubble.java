public class Bubble {

    public static void BubbleSort(int arr[]) {
        
        //o(n2) normally

        int swap=0; //for already sorted array {o(n)}

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    swap++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(swap==0){
                return;
            }
        }
    }

    public static void main(String[] args) {

        int arr[] = { 5, 4, 3, 2, 1 ,12,34,3,4,5,7,9};
        System.out.println();

        System.out.println("Before sorting : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        BubbleSort(arr);

        System.out.println();
        System.out.println();
        System.out.println("after sorting : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
