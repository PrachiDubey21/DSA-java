import java.util.*;

public class RankElements {

    public static int[] arrayRankTransform(int[] arr) {

        int[] temp = arr.clone();
        Arrays.sort(temp);

        HashMap<Integer, Integer> map = new HashMap<>();

        int j = 1;

        for (int num : temp) {

            if (!map.containsKey(num)) {
                map.put(num, j);
                j++;
            }
        }

        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {40, 10, 20, 30};

        int[] result = arrayRankTransform(arr);

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Rank Transformed Array: " + Arrays.toString(result));
   
    }

    
}
