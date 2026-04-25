import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

public class ActivitySelection {

    // Separate function to count maximum activities
    static int maxActivities(int[] start, int[] end) {

      
        // store index
        ArrayList<Integer> arr = new ArrayList<>();


        int count = 1; // first activity always selected
        int lastEnd = end[0]; // store end time of last selected activity
        arr.add(0);

        for (int i = 1; i < start.length; i++) {
            if (start[i] >= lastEnd) { // non-overlapping condition
                count++;
                arr.add(i);
                lastEnd = end[i]; // update end time
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.print("A" + arr.get(i) + " ");
        }
        System.out.println();

        return count;
    }

    public static void main(String[] args) {

        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 }; // already sorted end times

        System.out.println("Maximum Activities: " + maxActivities(start, end));
    }
}
