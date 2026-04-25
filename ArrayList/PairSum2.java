import java.util.ArrayList;
import java.util.Arrays;

public class PairSum2 {

  public static int findPivot(ArrayList<Integer> list) {

    // we can use a for loop too
    // list.get(i) > list.get(i+1);
    // pivot = i;

    int left = 0;
    int right = list.size() - 1;

    while (left < right) {

      int mid = left + (right - left) / 2;

      // If mid element is greater than right element,
      // pivot must be in the right part

      if (list.get(mid) > list.get(right)) {
        left = mid + 1;
      }
      // Otherwise pivot is in the left part (including mid)

      else {
        right = mid;
      }

    }

    // left == right is the pivot index
    return left;
  }

  public static int[] sum(ArrayList<Integer> list, int target, int pivot) {

    int left = pivot + 1;
    int right = pivot;
    int n = list.size();

    // Step 2: Two-pointer search
    while (left != right) {

      int sum = list.get(left) + list.get(right);

      if (sum == target) {
        return new int[] { list.get(left), list.get(right) };
      }

      if (sum < target) {

        left = (left + 1) % n; // need a bigger sum

      }

      else {

        right = (n + right - 1) % n; // need a smaller sum

      }
    }

    return new int[] { -1, -1 };
  }

  public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<>();

    list.add(11);
    list.add(15);
    list.add(6);
    list.add(8);
    list.add(9);
    list.add(10);

    int target = 16;

    // brute force
    int pivot = findPivot(list);
    int[] result = sum(list, target, pivot);
    System.out.println("Pair is: " + Arrays.toString(result));

  }
}
