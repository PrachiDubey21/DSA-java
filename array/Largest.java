public class Largest {

    public static int largest(int arr[] ){
         int max = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
    public static void main(String[] args) {

        int arr[] = { 35, 120, -5, 23, 19, 4 }; 
       int max= largest(arr);
         System.out.println("Largest element in array: " + max);
    }
}
