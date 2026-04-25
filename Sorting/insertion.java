public class insertion {

    //o(n2)

    public static void InsertionSort(int arr[]){

        //start from 2nd element
         for(int i = 1; i < arr.length; i++) {

            int key = arr[i]; // element to be placed
            int j = i - 1;   // index of previous element

            // move elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // place the key in its correct position
            arr[j + 1] = key;
        }
    }


    public static void print(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = { 5, 4, 3, 2, 1, 12, 34, 3, 4, 5, 7, 9 };

        System.out.println();
        System.out.println("Before sorting : ");
        print(arr);

        InsertionSort(arr);

        System.out.println();
        System.out.println("after sorting : ");
        print(arr);

    }

}
