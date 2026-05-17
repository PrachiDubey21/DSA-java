import java.util.*;

public class ThirdMaxNumber {

    public static int thirdMax(int[] nums) {

        Long first = null;
        Long second = null;
        Long third = null;

        for(int i = 0; i < nums.length; i++) {

            long num = nums[i];

            if((first != null && num == first) ||
               (second != null && num == second) ||
               (third != null && num == third)) {
                continue;
            }

            if(first == null || num > first) {

                third = second;
                second = first;
                first = num;

            } else if(second == null || num > second) {

                third = second;
                second = num;

            } else if(third == null || num > third) {

                third = num;
            }
        }

        return third == null ? first.intValue() : third.intValue();
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 3, 1};

        int result = thirdMax(nums);

        System.out.println("Third Maximum Number = " + result);
    }
}