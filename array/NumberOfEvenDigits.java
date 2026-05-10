import java.util.*;

public class NumberOfEvenDigits {

    public static void main(String[] args) {

        int[] nums = {12, 345, 2, 6, 7896};

        int count = 0;

        for(int i = 0; i < nums.length; i++) {

            int num = nums[i];

            int digits = 0;

            while(num > 0) {
                digits++;
                num = num / 10;
            }

            if(digits % 2 == 0) {
                count++;
            }
        }

        System.out.println("Numbers with even digits = " + count);
    }
    
}
