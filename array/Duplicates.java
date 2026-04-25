import java.util.*;

// Given an integer array nums,
//  return true if any value appears at least twice in the array, 
//  and return false if every element is distinct

public class Duplicates {

    public static boolean duplicate(int nums[]) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                   
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
        if (set.contains(nums[i])) {
            return true; // duplicate found
        }
        set.add(nums[i]);
    }

    return false; // no duplicate found
}

    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        boolean found=containsDuplicate(arr);
        if(found){
            System.out.println("there is a duplicate element  ");
        }
        else{
             System.out.println("there is no duplicate element ");
        }

    }

}
