import java.util.ArrayList;
import java.util.Collections;

public class LonelyNumber {

    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {

        // List to store lonely numbers
        ArrayList<Integer> list = new ArrayList<>();

        if (nums.size() == 0) {
            return list;
        }

        Collections.sort(nums);

        // Case: only one number → always lonely
        if (nums.size() == 1) {
            list.add(nums.get(0));
            return list;
        }

        // Check middle elements (1 to n-2)

        // leftNeighbour = nums.get(i - 1)
        // current = nums.get(i)
        // rightNeighbour = nums.get(i + 1)

        // Condition explanation:
        // - nums.get(i - 1) + 1 < nums.get(i)
        // ensures left neighbour is not equal to current-1
        // (and also not equal to current)
        // - nums.get(i) + 1 < nums.get(i + 1)
        // ensures right neighbour is not equal to current+1
        // (and also not equal to current)
        //
        // If both are true, the current number has no adjacent
        // value differing by 1.

        for (int i = 1; i < nums.size() - 1; i++) {

            // Check if previous number is NOT equal to current - 1
            // AND next number is NOT equal to current + 1
            if (nums.get(i - 1) + 1 < nums.get(i) &&
                    nums.get(i) + 1 < nums.get(i + 1)) {

                // If both true → number is lonely
                list.add(nums.get(i));
            }
        }

        // ---- Check the first element (index 0) ----
        // We only need to compare the first element
        // with the second element.
        // If first + 1 < second, then there is no (first+1)
        // value right after it,
        // and since it's the first element there is
        // no left neighbour to check.

        if (nums.get(0) + 1 < nums.get(1)) {
            list.add(nums.get(0));
        }

        // ---- Check the last element (index size-1) ----
        // We only need to compare the last element with 
        // the second-last element.
        // If secondLast + 1 < last, then there is no (last-1) value
        //  immediately before it.

        if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {
            list.add(nums.get(nums.size() - 1));
        }

        // Return final lonely numbers list
        return list;
    }

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(1);
        nums.add(3);
        nums.add(5);

        System.out.println("Input List: " + nums);

        // Call findLonely
        ArrayList<Integer> lonelyNumbers = findLonely(nums);

        // Print lonely numbers
        System.out.println("Lonely Numbers: " + lonelyNumbers);
    }

}
