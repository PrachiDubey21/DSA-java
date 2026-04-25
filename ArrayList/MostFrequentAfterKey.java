import java.util.ArrayList;

public class MostFrequentAfterKey {

    // Function to find the most frequent number following the key
    public static int mostFrequent(ArrayList<Integer> nums, int key) {

        // Frequency array (because values range from 1 to 1000)
        int[] result = new int[1000];

        // Count occurrences of numbers following the key
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                result[nums.get(i + 1) - 1]++;
            }
        }

        // Find the number with maximum frequency
        int max = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < 1000; i++) {
            if (result[i] > max) {
                max = result[i];
                ans = i + 1;
            }
        }

        return ans;
    }

    // Main function
    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>();

        // Sample Input 1
        nums.add(1);
        nums.add(100);
        nums.add(200);
        nums.add(1);
        nums.add(100);

        int key = 1;

        int result = mostFrequent(nums, key);

        System.out.println("Most frequent number following the key is: " + result);
    }
}
