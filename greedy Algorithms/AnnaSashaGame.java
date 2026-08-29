import java.util.Arrays;

public class AnnaSashaGame {

    static String solve(int[] nums, int m) {

        int totaldigits = 0;
        int[] zerodigits = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            int temp = num;
            while (temp > 0) {
                totaldigits++;
                temp = temp / 10;
            }

            temp = num;
            int zeros = 0;

            while (temp % 10 == 0) {
                zeros++;
                temp /= 10;
            }

            zerodigits[i] = zeros;
        }

        Arrays.sort(zerodigits);

        int removedzeros = 0;
        for (int i = zerodigits.length - 1; i >= 0; i -= 2) {
            removedzeros += zerodigits[i];
        }

        int remainingdigits = totaldigits - removedzeros;

        if (remainingdigits > m) {
            return "Sasha";
        } else {
            return "Anna";
        }
    }

    public static void main(String[] args) {

        int[] nums = {14, 2};
        int m = 2;

        String answer = solve(nums, m);
        System.out.println(answer);

    }
    
}