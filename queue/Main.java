import java.util.*;

class SlidingWindowOrMaxInSubArray {

    public int[] maxSlidingWindow(int[] nums, int k) {

        // Deque stores INDEXES of array elements (not values)
        // We store indexes so we can:
        // 1. Check if element is out of window
        // 2. Compare values using nums[index]
        Deque<Integer> dq = new LinkedList<>();

        int n = nums.length; // size of input array

        // result array to store maximum of each window
        int[] result = new int[n - k + 1];

        int r = 0; // pointer for result array

        // traverse every element
        for (int i = 0; i < n; i++) {

            // STEP 1: REMOVE OUT OF WINDOW ELEMENTS

            // if front index is outside current window, remove it
            // window start = i - k + 1
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst(); // remove outdated index
            }

            // STEP 2: REMOVE SMALLER ELEMENTS FROM BACK

            // remove all elements smaller than current element
            // because they can never be maximum in future windows
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast(); // remove useless smaller element
            }

            // STEP 3: ADD CURRENT ELEMENT INDEX

            dq.offerLast(i); // add current index to deque

            // STEP 4: STORE ANSWER WHEN FIRST WINDOW IS READY

            if (i >= k - 1) {

                // front of deque always has maximum element index
                result[r] = nums[dq.peekFirst()];

                // move result pointer
                r++;
            }
        }

        // return final result array
        return result;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // INPUT: size of array
        int n = sc.nextInt();

        int[] nums = new int[n];

        // INPUT: array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // INPUT: window size
        int k = sc.nextInt();

        // create object of solution class
        SlidingWindowOrMaxInSubArray obj = new SlidingWindowOrMaxInSubArray();

        // get result from function
        int[] ans = obj.maxSlidingWindow(nums, k);

        // OUTPUT: print result
        for (int x : ans) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}