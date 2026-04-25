public class MajorityElement {

    // Logic (Very Simple Explanation)
    // Take a candidate.
    // Maintain a count.
    // If the next number is same → increase count
    // If different → decrease count
    // If count becomes 0 → choose a new candidate

    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public int majorityElement2(int[] nums) {

        // Step 1: find max value to create frequency array
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // Step 2: create count array
        int[] count = new int[max + 1];

        // Step 3: fill count array
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        // Step 4: find element with highest count
        int majority = nums[0];
        int highest = count[majority];

        for (int i = 1; i < count.length; i++) {
            if (count[i] > highest) {
                highest = count[i];
                majority = i;
            }
        }

        return majority; // majority always exists
    }

    public static void main(String[] args) {

        int arr[] = { 2, 2, 1, 1, 2, 2, 2, 3, 4 };
        System.out.println(majorityElement(arr));
    }
}
