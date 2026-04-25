public class Counting {

    public static void CountSort(int arr[]){
         // Step 1: Find maximum element
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Step 2: Create count array
        int count[] = new int[max + 1];

        // Step 3: Count occurrences of each number
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Step 4: Place values in sorted order
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
    }

      public static void print(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = { 5, 4, 3, 2, 1, 12, 3, 4, 5, 7, 9 };

        System.out.println();
        System.out.println("Before sorting : ");
        print(arr);

        CountSort(arr);

        System.out.println();
        System.out.println("after sorting : ");
        print(arr);

    }
    
}
