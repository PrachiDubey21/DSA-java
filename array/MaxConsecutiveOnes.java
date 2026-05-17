public class MaxConsecutiveOnes {

    public static void main(String[] args) {

        int nums[] = {1, 1, 0, 1, 1, 1};

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }

        maxCount = Math.max(maxCount, count);

        System.out.println(maxCount);
    }
}