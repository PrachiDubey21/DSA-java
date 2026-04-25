import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PairSum {

    public static int[] sum2(ArrayList<Integer> list, int target) {

    
        int left = 0;
        int right = list.size() - 1;

        // Step 2: Two-pointer search
        while (left < right) {

            int sum = list.get(left) + list.get(right);

            if (sum == target) {
                return new int[]{list.get(left), list.get(right)};
            }

            if (sum < target) {
                left++;  // need a bigger sum
            } else {
                right--; // need a smaller sum
            }
        }

        return new int[]{-1, -1};
    }


    public static int[] sum(ArrayList<Integer> list, int target) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                int sum = list.get(i) + list.get(j);
                if (sum == target) {
                    return new int[] { list.get(i), list.get(j) };
                }
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int target = 5;

        //brute force
         int[] result = sum(list, target);
        System.out.println("Pair is: " + Arrays.toString(result));

         //2 pointer approach
         int[] result2 = sum(list, target);
        System.out.println("Pair is: " + Arrays.toString(result2));
    }

}
