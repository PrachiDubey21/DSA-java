import java.util.*;

public class FairCandySwap {

    public static int[] fairCandySwap(int[] size1, int[] size2) {

        int sum1 = 0;
        int sum2 = 0;

        for (int num : size1) {
            sum1 += num;
        }

        for (int num : size2) {
            sum2 += num;
        }

        int difference = (sum1 - sum2) / 2;

        HashSet<Integer> set = new HashSet<>();

        for (int num : size2) {
            set.add(num);
        }

        for (int a : size1) {

            int b = a - difference;

            if (set.contains(b)) {
                return new int[]{a, b};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 2, 5};
        int[] arr2 = {1, 4, 6};

        int[] result = fairCandySwap(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
    
}