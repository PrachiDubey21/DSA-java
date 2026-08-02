import java.util.*;

public class FirstAndLastOcc {

    public static int[] search(int[] nums, int target) {

        int f = first(nums, target);
        int l = last(nums, target);

        return new int[]{f, l};
    }

    public static int first(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int first = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                first = mid;
                right = mid - 1;

            } else if (nums[mid] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return first;
    }

    public static int last(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int last = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                last = mid;
                left = mid + 1;

            } else if (nums[mid] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return last;
    }

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = search(nums, target);
        System.out.println(Arrays.toString(result));
    }
    
}