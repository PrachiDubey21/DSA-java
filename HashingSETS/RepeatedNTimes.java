import java.util.*;

public class RepeatedNTimes {

    public static int repeatedNTimes(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {

            if(set.contains(num)) {
                return num;
            }

            set.add(num);
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 2, 5, 3, 2};

        int result = repeatedNTimes(nums);
        System.out.println("Repeated N Times Element = " + result);
        
    }
    
}
