import java.util.ArrayList;
import java.util.List;

public class Permutation {

    // public static void per(String str, String ans) {

    //     // base case
    //     if (str.length() == 0) {
    //         System.out.println(ans);
    //         return;
    //     }

    //     // recursion
    //     for (int i = 0; i < str.length(); i++) {

    //         char curr = str.charAt(i);
    //         // "abcde" if we pick c then "ab" + "de"
    //         String newstr = str.substring(0, i) + str.substring(i + 1);

    //         per(newstr, ans + curr);

    //     }
    // }

    public static void perArray(int[] arr, List<Integer> ans,
            List<List<Integer>> result) {

        // base case
        if (arr.length == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }

        // recursion
        for (int i = 0; i < arr.length; i++) {

            int curr = arr[i]; // pick current number

            // create new array by removing current element
            int[] newArr = new int[arr.length - 1];
            int idx = 0;

            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    newArr[idx++] = arr[j];
                }
            }

            // add current to ans
            ans.add(curr);

            perArray(newArr, ans, result);

            // BACKTRACK
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {

        // String str = "pra";
        // per(str, "");

        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = new ArrayList<>();
        perArray(nums, new ArrayList<>(), result);
         System.out.println(result); // print final answer

    }

}
