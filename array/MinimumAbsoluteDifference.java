import java.util.*;

public class MinimumAbsoluteDifference {

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        // find minimum difference
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        List<List<Integer>> result = new ArrayList<>();

        // collect all pairs
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};

        List<List<Integer>> ans = minimumAbsDifference(arr);

        System.out.println(ans);
    }
    
}
