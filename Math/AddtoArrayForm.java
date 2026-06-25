import java.util.*;

// k += current digit
// take last digit using %10
// remove last digit using /10

public class AddtoArrayForm {

    public static List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> ans = new ArrayList<>();

        for (int i = num.length - 1; i >= 0; i--) {

            k = k + num[i];
             int digit = k%10;
             k = k/10;
             ans.add(digit);
        }

        while (k > 0) {

             int digit = k%10;
             k = k/10;
             ans.add(digit);
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {

        int[] num = {1, 2, 0, 0};
        int k = 34;

        System.out.println(addToArrayForm(num, k));
    }
}